$(document).ready(function() {
	$('#submitBtn').click(function() {
		if (validateForm()) {
			saveStudent();
		}
	});
});

function validateForm() {
	let isValid = true;

	const rollno = $('#rollno').val().trim();
	const name = $('#name').val().trim();
	const standard = $('#standard').val().trim();
	const division = $('#division').val().trim();
	const address = $('#address').val().trim();
	const mobileno = $('#mobileno').val().trim();

	$('.error').text('');

	if (rollno === "") {
		$('#rollnoError').text("Roll number cannot be empty");
		isValid = false;
	}

	if (name.length < 3) {
		$('#nameError').text("Name must be at least 3 characters long");
		isValid = false;
	}

	if (standard === "") {
		$('#standardError').text("Standard cannot be empty");
		isValid = false;
	}

	if (division === "") {
		$('#divisionError').text("Division cannot be empty");
		isValid = false;
	}

	if (address === "") {
		$('#addressError').text("Address cannot be empty");
		isValid = false;
	}

	const mobilePattern = /^[0-9]{10}$/;
	if (!mobilePattern.test(mobileno)) {
		$('#mobilenoError').text("Mobile number must be 10 digits");
		isValid = false;
	}

	return isValid;
}


function saveStudent() {
	const user = {
		rollno: $('#rollno').val(),
		name: $('#name').val(),
		standard: $('#standard').val(),
		division: $('#division').val(),
		address: $('#address').val(),
		mobileno: $('#mobileno').val()
	};

	$.ajax({
		type: "POST",
		url: "/api/savestudent",
		contentType: "application/json",
		data: JSON.stringify(user),
		success: function(response) {
			alert("User registered successfully");
			$('#registrationForm')[0].reset();
			getStudents();
		},
		error: function(error) {
			console.error("Error:", error);
			alert("Error saving the student");
		}
	});
}

function getStudents() {
	$.ajax({
		type: "GET",
		url: "/api/getstudents",
		success: function(data) {
			let tableRows = '';
			data.forEach(function(student) {
				tableRows += `
                    <tr>
                        <td>${student.rollno}</td>
                        <td>${student.name}</td>
                        <td>${student.standard}</td>
                        <td>${student.division}</td>
                        <td>${student.address}</td>
                        <td>${student.mobileno}</td>
                        <td>
                            <button class="btn btn-danger" onclick="deleteStudent(${student.rollno})">Delete</button> 
                            <button class="btn btn-primary" onclick="getStudentByRollno(${student.rollno})">Edit</button>
                        </td>
                    </tr>`;
			});
			$('#table-body').html(tableRows);
		},
		error: function(error) {
			console.error("Error fetching students:", error);
			alert("Error fetching student data.");
		}
	});
}

function getStudentByRollno(rollno) {
	$.ajax({
		type: "GET",
		url: `/api/getstudent/${rollno}`,
		success: function(student) {
			
			$('#editRollno').val(student.rollno);
            $('#editName').val(student.name);
            $('#editStandard').val(student.standard);
            $('#editDivision').val(student.division);
            $('#editAddress').val(student.address);
            $('#editMobileno').val(student.mobileno);

			console.log(rollno);
			$('#editUserModal').modal('show')
			
		},
		error: function() {
			alert("Error fetching student");
		}
	});

}


function updateStudent() {
    const user = {
        rollno: $('#editRollno').val(),     
        name: $('#editName').val(),
        standard: $('#editStandard').val(),
        division: $('#editDivision').val(),
        address: $('#editAddress').val(),
        mobileno: $('#editMobileno').val()
    };

    $.ajax({
        type: "PUT",
        contentType: "application/json",
        url: `/api/updatestudent/${user.rollno}`,
        data: JSON.stringify(user),
        success: function() {
            alert("User updated successfully");
            $('#editUserModal').modal('hide');
            getStudents(); 
        },
        error: function() {
            alert("Error while updating student");
        }
    });
}


function deleteStudent(rollno) {
    if (confirm("Are you sure you want to delete this Student?")) {
        $.ajax({
            type: "DELETE",
            url: `/api/deletestudent/${rollno}`,  
            success: function() {
                alert("User deleted successfully");
                getStudents();  
            },
            error: function() {
                alert("Error deleting user");
            }
        });
    }
}



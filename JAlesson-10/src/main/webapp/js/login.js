const signInBtn = document.getElementById("signIn");
const signUpBtn = document.getElementById("signUp");
const fistForm = document.getElementById("form1");
const secondForm = document.getElementById("form2");
const container = document.querySelector(".container");

signInBtn.addEventListener("click", () => {
	container.classList.remove("right-panel-active");
});

signUpBtn.addEventListener("click", () => {
	container.classList.add("right-panel-active");
});

fistForm.addEventListener("submit", (e) => e.preventDefault());
secondForm.addEventListener("submit", (e) => e.preventDefault());

$(document).ready(function() {
	$("button.btn1").click(function() {
		var name = $("form.form1 input.user_name").val();
		var email = $("form.form1 input.email").val();
		var password = $("form.form1 input.password").val();

		if (name == '' || email == '' || password == '') {
			alert("Please fill all fields...!!!!!!");
		} else if ((password.length) < 8) {
			alert("Password should atleast 8 character in length");
		} else {
			var userRegistration = {
				name: name,
				email: email,
				password: password
			};
			$.post("registration", userRegistration, function(data) {
				if (data !== '') {
					$("form")[0].reset();
					$("form")[1].reset();
					alert('Success');
				}
			});
		}
	});
});
$(document).ready(function() {
	$("button.btn2").click(function() {
		var email = $("form.form2 input.email").val();
		var password = $("form.form2 input.password").val();

		if (email == '' || password == '') {
			alert("Please fill data");
		} else {
			var userLoggin = {
				email: email,
				password: password
			};
			$.post("login", userLoggin, function(data) {
				if (data !== '') {
					var customUrl = '';
					var urlContent = window.location.href.split('/');
					for (var i = 0; i < urlContent.length - 1; i++) {
						customUrl += urlContent[i] + '/'
					}
					customUrl += data.destinationUrl;
					window.location = customUrl;
				}
				$("form")[1].reset();
			});
		}
	});
});
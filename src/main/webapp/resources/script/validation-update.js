$(document).ready(() => {
	$('.error-msg').css('color', 'red');
	$('.error-msg').hide();
	
	$('#phone').focusout(e => {
		const phone = $('#phone').val();
		if (phone.match(/\d{3}-\d{4}-\d{4}|\d{11}/) === null) {
			$('#error-msg-phone-pattern').show();
		} else {
			$('#error-msg-phone-pattern').hide();
		}
	});
	
	$('#email').focusout(e => {
		const email = $('#email').val();
		if (email.match(/[0-9a-zA-Z]{4,20}@[a-z]{3,10}.(com|co.kr)/) === null) {
			$('#error-msg-email-pattern').show();
		}else {
			$('#error-msg-email-pattern').hide();
		}
	});

	$('form').submit(() => {
		e.preventDefault();

		if (isValid) {
			e.target.submit();
		}
	});
});
$(document).ready(() => {
	$('.error-msg').css('color','red');
	$('.error-msg').hide();
	
	$('#id').focusout(e => {
		if($('#id').val() === "") {
			$('#error-msg-id').show();
			$('#id').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-id').hide();
			$('#id').css('border', 'solid 1px lightgrey');
			$('#id').css('border-bottom', 'none');
		}
	});
	
	$('#password').focusout(e => {
		if($('#password').val() === "") {
			$('#error-msg-password').show();
			$('#password').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-password').hide();
			$('#password').css('border', 'solid 1px lightgrey');
			$('#password').css('border-bottom', 'none');
		}
	});
	
	$('#resident-number').focusout(e => {
		if($('#resident-number').val() === "") {
			$('#error-msg-resident-number').show();
			$('#resident-number').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-resident-number').hide();
			$('#resident-number').css('border', 'solid 1px lightgrey');
			$('#resident-number').css('border-bottom', 'none');
		}
	});
	
	$('#phone').focusout(e => {
		if($('#phone').val() === "") {
			$('#error-msg-phone').show();
			$('#phone').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-phone').hide();
			$('#phone').css('border', 'solid 1px lightgrey');
			$('#phone').css('border-bottom', 'none');
		}
	});
	
	$('#name').focusout(e => {
		if($('#name').val() === "") {
			$('#error-msg-name').show();
			$('#name').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-name').hide();
			$('#name').css('border', 'solid 1px lightgrey');
			$('#name').css('border-bottom', 'none');
		}
	});
	
	$('form').submit(()=>{
		e.preventDefault();
		
		const id = $('#id').val();
		const password = $('#password').val();
		const email = $('#email').val();			// 선택 
		const residentNumber = $('#resident-number').val();
		const phone = $('#phone').val();
		const gender = $('#gender').val();
		const name = $('#name').val();
		
		let isValid = true;
		
		if(id===''){
			$('#error-msg-id').show();
			isValid = false
		}
		
		if(password===''){
			$('#error-msg-password').show();
			isValid = false
		}
		
		if(residentNumber===''){
			$('#error-msg-resident-number').show();
			isValid = false
		}
		
		if(phone===''){
			$('#error-msg-phone').show();
			isValid = false
		}
		
		if(name===''){
			$('#error-msg-name').show();
			isValid = false
		}
		
		if(phone.match(/\d{3}-\d{4}-\d{4}|\d{11}/) === null) {
			$('#error-msg-phone-pattern').show();
			isValid = false
		}
		
		if(residentNumber.match(/\d{6}-\d{7}|\d{13}/) === null) {
			$('#error-msg-resident-number-pattern').show();
			isValid = false
		}
		
		if(email.match(/[0-9a-zA-Z]{4,20}@[a-z]{3,10}.(com|co.kr)/) === null) {
			$('#error-msg-email-pattern').show();
			isValid = false
		}
		
		if(isValid){
			e.target.submit();
		}
	});
});
$(document).ready(() => {
	$('.show-in-mypage').hide();
	$('#reservation-check-container').show();
	
	$('#reservation-check-p').click(() => {
		$('.show-in-mypage').hide();
		$('#reservation-check-container').show();
	})

	$('#modify-user-data-p').click(() => {
		$('.show-in-mypage').hide();
		$('#modify-user-data-container').show();
	})

	$('#leave-user-p').click(() => {
		$('.show-in-mypage').hide();
		$('#leave-user-container').show();
	})
});
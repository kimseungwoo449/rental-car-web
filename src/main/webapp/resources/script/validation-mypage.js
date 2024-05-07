$(document).ready(() => {
	$('.show-in-mypage').hide();
	$('#reservation-check-container').show();

	$('#reservation-check').click(() => {
		$('.show-in-mypage').hide();
		$('#reservation-check-container').show();
	})

	$('#modify-user-data').click(() => {
		$('.show-in-mypage').hide();
		$('#modify-user-data-container').show();
	})

	$('#leave-user').click(() => {
		$('.show-in-mypage').hide();
		$('#leave-user-container').show();
	})
});
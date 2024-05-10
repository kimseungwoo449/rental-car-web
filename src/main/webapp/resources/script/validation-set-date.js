$('document').ready(() => {
	let dt = new Date();
	
	$('#resev-date').val(dt.toISOString().substring(0, 10));
	dt.setDate((dt.getDate() + 3));
	$('#return-date').val(dt.toISOString().substring(0, 10));
	
});
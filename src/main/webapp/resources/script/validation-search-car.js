$('document').ready(() => {
	$('#search-option').change(() => {
		$('#search-value-container').children().remove();
		let searchValue;
		if ($('#search-option').val() === 'category') {
			searchValue = document.createElement("select");
			searchValue.setAttribute("name", "search-value");
			searchValue.setAttribute("id", "search-value");
			
			const option1 = document.createElement("option");
			option1.setAttribute("disabled","disabled");
			option1.setAttribute("selected","selected");
			option1.innerText+='차량크기';
			const option2 = document.createElement("option");
			option2.setAttribute("value","1001");
			option2.innerText+='경형/소형';
			const option3 = document.createElement("option");
			option3.setAttribute("value","1000");
			option3.innerText+='중형';
			const option4 = document.createElement("option");
			option4.setAttribute("value","1002");
			option4.innerText+='대형';
			searchValue.append(option1);
			searchValue.append(option2);
			searchValue.append(option3);
			searchValue.append(option4);
		} else {
			searchValue = document.createElement("input");
			searchValue.setAttribute("type", "text");
			searchValue.setAttribute("name", "search-value");
			searchValue.setAttribute("id", "search-value");
			searchValue.setAttribute("placeholder", "검색할 내용");			
		}
		$('#search-value-container').append(searchValue);
		
	});

	$('form').submit(e => {
		e.preventDefault();

		if ($('.search-value').val() !== null && $('.search-value').val() !== '') {
			e.target.submit();
		}
	});
})
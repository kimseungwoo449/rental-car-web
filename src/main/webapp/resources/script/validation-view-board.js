$(document).ready(() => {
	$.ajax({
		"method": "POST",
		"url": `http://localhost:8080/allBoard`,
	}).done(response => {
		console.log('response : ', response);
		
		for (let i = 0; i < response.length; i++) {
			const object = response[i];
			if (!object.is_notice) {
				const title = object.title;
				const userId = object.user_id;
				const contents = object.contents;
				const post = document.createElement('p');
				post.setAttribute('id','post'+i);
				post.innerHTML+=`<span>${userId}</span><span>${title}</span>`;
				$('#root').append(post);
			}
		}
	});
})
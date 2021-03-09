window.onload = function(){
	tinymce.init({
		selector:"#content",
		plugins:"advlist autolink link image lists charmap print preview codesample emoticons textcolor",
		toolbar:['undo redo | styleselect | bold italic | link imageupload codesample | forecolor backcolor emoticons'],
		height:400,
		menubar:false,
		codesample_languages:[
			{text:'HTML/XML', value:'markup'},
			{text:'Javascript', value:'javascript'},
			{text:'CSS', value:'css'},
			{text:'Java', value:'java'}
		],
		setup:function(editor) {
			//setup은 타이니가 실행될 때 만들어진 에디터 객체를 반환하고 이 때 이 editor를 이용해서 내가 하고자하는 환경설정을 수행할 수 있다.
			let inp = $('<input id="tinymce-uploader" type="file" name="plc" accept="image/*" style="display:none;">');
			$(editor.getElement()).parent().append(inp);
			
			editor.addButton("imageupload", {
				icon:'image',
				onclick:function(e) {
					inp.click();
				}
			});
			
			inp.on("change", function(e) {
				let input = inp[0]; //제이쿼리 객체의 0번째는 항상 dom element
				let data = new FormData();
				data.append("file", input.files[0]);
				
				$.ajax({
					url:'/board/upload',
					type:'POST',
					data:data,
					enctype:'multipart/form-data',
					dataType:'json',
					processData:false, //이거 옵션 false로 안주면 강제로 queryString으로 변환한다.
					contentType:false, //전송 데이터 컨텐츠 타입을 false로 주면 제이쿼리가 알아서 판단한다
					success:function(data) {
						editor.insertContent(
							`<img class="content-img" src="${data.uploadImage}" data-mce-src="${data.uploadImage}">`
						);
					},
					error:function(err) {
						console.log(err);
					}
				});
			});
		}
	});
}
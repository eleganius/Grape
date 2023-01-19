//フォロワーリスト
$('#followee').click(function() {

	function clone(followee) {
		const clone = $($('#row-template').html());
		clone.attr('href', '/user/show' + followee.followeeId);//clone自体がa要素
		clone.find('img').attr('src', '/uploads/' + followee.userList[0].avatar);
		clone.find('strong').append(followee.userList[0].name);
		return clone;
	}

	$.ajax({
		url: 'http://localhost:8888/follow/followee',
		type: 'GET',
		data: { userId: $('#followee').data().userid },
		dataType: 'JSON'
	})
		.done(function(res) {
			console.log(res);
			const template = $($('#template').html());
			for (let followee of res) {
				template.find('div').append(clone(followee));
			}
			$('#modal-header').after(template);
			$('#exampleModalLabel').append('フォロワー');
		})
		.fail(function() {
			alert('失敗');
		});

});

//フォロー中リスト
$('#following').click(function() {

	function clone(following) {
		const clone = $($('#row-template').html());
		clone.attr('href', '/user/show/' + following.followeeId);//clone自体がa要素
		clone.find('img').attr('src', '/uploads/' + following.userList[0].avatar);
		clone.find('strong').append(following.userList[0].name);
		return clone;
	}

	$.ajax({
		url: 'http://localhost:8888/follow/following',
		type: 'GET',
		data: { userId: $('#following').data().userid },
		dataType: 'JSON'
	})
		.done(function(res) {
			console.log(res);
			const template = $($('#template').html());
			for (let following of res) {
				console.log(following);
				template.find('div').append(clone(following));
			}
			$('#modal-header').after(template);
			$('#exampleModalLabel').append('フォロー中');
		})
		.fail(function() {
			alert('失敗');
		});

});
//モーダル閉じたらデータ削除
$('#closeModal').click(function() {

	$('.modal-body').remove();
	$('#exampleModalLabel').empty();

});
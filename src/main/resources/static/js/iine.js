'use strict';

{
	$(document).ready(function() {

		//非同期いいね
		let $iines = $('.iine'); //$iineの$はjQueryオブジェクトであることを明示的に表示（jQueryメソッドが使える）

		for (let i = 0; i < $iines.length; i++) {
			$iines[i].addEventListener('click', function() {
				
				//デバッグ用
				console.log($(this));
				console.log($(this).data());
				console.log($(this).data().articleid);
				console.log($(this).attr('id'));

				//addなのかdeleteなのかswitchで分岐
				switch ($(this).attr('id')) {

					case "yet":
						$.ajax({
							url: 'http://localhost:8888/like/add',
							type: 'GET',
							data: { articleId: $(this).data().articleid }, //カスタムデータ属性
							dataType: 'JSON',
							context: this, //.doneブロックでも$(this)が使える
						})
							.done(function(res) {

								console.log(res); //デバッグ用

								//ハート属性変更
								$(this).attr('id', 'done');
								$(this).toggleClass('bi-suit-heart-fill');
								$(this).toggleClass('bi-suit-heart');

								//いいね数を最新数に書き換え
								$(this).next()
									.empty()
									.append(res);

							})
							.fail(function() {
								alert('insert失敗');
							});
						break;

					case "done":
						$.ajax({
							url: 'http://localhost:8888/like/delete',
							type: 'GET',
							data: { articleId: $(this).data().articleid },
							dataType: 'JSON',
							context: this,
						})
							.done(function(res) {

								console.log(res);

								//ハート属性変更
								$(this).attr('id', 'yet');
								$(this).toggleClass('bi-suit-heart-fill');
								$(this).toggleClass('bi-suit-heart');

								//いいね数を最新数に書き換え
								$(this).next()
									.empty()
									.append(res);

							})
							.fail(function() {
								alert('delete失敗');
							});
						break;
				}

			});
		}

	});

}
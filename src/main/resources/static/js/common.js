'use strict';

{

	//articleList以外検索フォーム非表示
	const url = new URL(window.location.href);
	console.log(url);//デバッグ用

	if (url.pathname !== '/') {

		const search = document.getElementById('search');

		search.remove();

	}

	//ログアウトアラート
	const logout = document.getElementById('logout');

	logout.addEventListener('click', e => {

		const result = confirm("ログアウトしますか？");

		if (!result) {
			e.preventDefault();
		}

	});

}
'use strict';

{

	const url = new URL(window.location.href);
	console.log(url);//デバッグ用

	//articleList以外検索フォーム非表示
	if (url.pathname !== '/grape/articles/articleList') {

		const search = document.getElementById('search');

		search.remove();

	}

	//loginまたはaddUserではheader-links非表示
	if (url.pathname === '/grape/login') {

		const headerLinks = document.getElementById('header-links');

		headerLinks.remove();

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
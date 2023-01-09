'use strict';

{
	$(document).ready(function() {

		//いいねトグル
		$('.iine').click(function() {
			$(this).toggleClass('bi-suit-heart-fill');
			$(this).toggleClass('bi-suit-heart');
		});

	});
	
}
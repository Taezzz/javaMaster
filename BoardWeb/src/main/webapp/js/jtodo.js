/**
 * 	jtodo.js
 *  jquery버전의 todo리스트 기능 구현.
 */

$(document).ready(function() {

	$('li').append($('<span />').text("\u00D7").addClass('close').on('click', function(e) {
		$(this).parent().css('display', 'none');
	}));


	$('ul').on('click', function(e) {
		if (e.target.tagName == 'LI') {
			$(e.target).toggleClass('checked');
		}
	});

	function newElement() {
		var inputValue = $('#myInput').val();
		var li = $('<li />').text(inputValue);
		if (inputValue == '') {
			alert("You must write something!")
		} else {
			li.appendTo('#myUL');
		}
		$('li').append($('<span />').text("\u00D7").addClass('close').on('click', function(e) {
			$(this).parent().css('display', 'none');
		}));
	}
	$('.addBtn').on('click', newElement);

});

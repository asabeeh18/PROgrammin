
var chapterLinks = $('table.listing a').map(function(i,el) { return $(el).attr('href'); });		
var startchapter; 
do {
	startchapter = prompt("Enter chapter number you want to start from:");
	if (startchapter === null) {
		throw new Error("Script cancelled by user!");
	}
	startchapter = Number(startchapter);
	if (startchapter <= 0 || startchapter > chapterLinks.length) {
		alert("chapter number must be greater than 0 and less than " + chapterLinks.length); 
		} else {
		break; 
	}
} while(true); 
console.log('Starting chapter: ' + startchapter)

var endchapter; 
do {
	endchapter = prompt("Enter chapter number you want to end at:");
	if (endchapter === null) {
		throw new Error("Script cancelled by user!");
	}
	endchapter = Number(endchapter);
	if (endchapter <= 0 || endchapter > chapterLinks.length || endchapter < startchapter) {
		alert("chapter number must be greater than 0 and less than " + chapterLinks.length);
		} else {
		break;
	}
} while(true); 
console.log('Ending chapter: ' + endchapter)

var link=new Array(endchapter- startchapter);

$.ajaxSetup({async:false});
var URL = window.location.origin;
var re=/(http.*\.jpg)/g;
for (i = (chapterLinks.length - startchapter); i >= (chapterLinks.length - endchapter); i--) 
{
	jQuery.ajax({
        url: URL + chapterLinks[i], 
        success: function(result) {
        	link.push(result.match(re));
			console.log("success:"+i);
		},
        async:   false, 
		script:  true
	});
}
console.log(link);
copy(link);
//提示升级浏览器
function mask() {
	var div_mask = '<div id="jk-mask" style="padding: 45px 0px;position: absolute;top: 50%;left: 0;z-index: 5000;margin-top: -150px;height: 300px;width: 100%;background:#f9fcd2;">';	
		div_mask += '<div class="w-1000" style="position: relative;width: 1000px;margin: 0 auto;text-align: center;">';
		div_mask +='<img src="//e.jikexueyuan.com/headerandfooter/images/close.png" id="close" style="position: absolute;right: 0;top: -30px;z-index: 5003;cursor: pointer;"/>';
		div_mask +='<h3 style="font-size: 18px;color: #333;font-weight: 400;margin-bottom: 25px;">使用一款<span style="color: #35b558;"> 优质浏览器，是成为极客</span> 的关键一步！</h3>';
		div_mask +='<p style="color: #666;font-size: 13px;display: block;margin-bottom: 45px;">您当前使用的浏览器版本过低，将会影响到您的浏览体验，建议使用更高版本浏览器 chrome / firefox / ie / safari</p>';
		div_mask +='<div class="downloading">';
		div_mask +='<a href="http://www.firefox.com.cn/download/" target="_blank" style="display: inline-block;width: 100px;margin: 0px 20px;text-decoration: none;">';
		div_mask +='<img src="//e.jikexueyuan.com/static/images/browser/firefox.png">';
		div_mask +='<span class="name" style="display: block;font-size: 14px;color: #666;">Firefox</span><span style="display: block;color: #999;font-size: 12px;">PC/Mac/Linux</span></a>';
		div_mask +='<a href="http://wirrorcdn.qiniudn.com/software/browser/ChromeStandaloneSetup.Win.38.0.2125.111.exe" target="_blank" style="display: inline-block;width: 100px;margin: 0px 20px;text-decoration: none;">';
		div_mask +='<img src="//e.jikexueyuan.com/static/images/browser/chrome.png">';
		div_mask +='<span class="name" style="display: block;font-size: 14px;color: #666;">Chrome</span><span style="display: block;color: #999;font-size: 12px;">PC/Mac/Linux</span></a>';
		div_mask +='<a href="http://windows.microsoft.com/zh-cn/internet-explorer/ie-11-worldwide-languages/" target="_blank" style="display: inline-block;width: 100px;margin: 0px 20px;text-decoration: none;">';
		div_mask +='<img src="//e.jikexueyuan.com/static/images/browser/ie.png"><span class="name" style="display: block;font-size: 14px;color: #666;">IE 11</span><span style="display: block;color: #999;font-size: 12px;">PC</span></a>';
		div_mask +='<a href="http://support.apple.com/kb/DL1531" target="_blank" style="display: inline-block;width: 100px;margin: 0px 20px;text-decoration: none;">';
		div_mask +='<img src="//e.jikexueyuan.com/static/images/browser/safari.png"><span class="name" style="display: block;font-size: 14px;color: #666;">safari</span>';
		div_mask +='<span style="display: block;color: #999;font-size: 12px;">Mac</span></a></div></div></div>';

	var userBrowser = navigator.userAgent;
	var Browser = {
		IE6: (/msie\s*(\d+)\.\d+/g.exec(userBrowser.toLowerCase()) || [0, "0"])[1] == "6",
		IE7: userBrowser.indexOf('MSIE 7.0') > -1,
		IE8: userBrowser.indexOf('MSIE 8.0') > -1,
		IE9: userBrowser.indexOf('MSIE 9.0') > -1
	};
	function parseDom(arg) { //把字符串转换为DOM节点
		var objE = document.createElement("div");
		objE.innerHTML = arg;
		return objE.childNodes;
	}
	if(Browser.IE6 == true || Browser.IE7 == true || Browser.IE8 == true || Browser.IE9 == true) {
		var objE = document.createElement("div");
		objE.innerHTML = div_mask;
		document.getElementsByTagName("body")[0].appendChild(objE);
		var close = document.getElementById('close');
		close.onclick = function() {
			var jkmask = document.getElementById('jk-mask');
			jkmask.parentNode.removeChild(jkmask);
		}
	}
}
window.onload = function(){
	mask();
}

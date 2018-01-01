(function(){var f=this;function g(a){a=a.split(".");for(var c=f,b;b=a.shift();)if(null!=c[b])c=c[b];else return null;return c}
function h(a,c,b){return a.call.apply(a.bind,arguments)}
function k(a,c,b){if(!a)throw Error();if(2<arguments.length){var d=Array.prototype.slice.call(arguments,2);return function(){var b=Array.prototype.slice.call(arguments);Array.prototype.unshift.apply(b,d);return a.apply(c,b)}}return function(){return a.apply(c,arguments)}}
function l(a,c,b){l=Function.prototype.bind&&-1!=Function.prototype.bind.toString().indexOf("native code")?h:k;return l.apply(null,arguments)}
var m=Date.now||function(){return+new Date};
function p(a,c){var b=a.split("."),d=f;b[0]in d||!d.execScript||d.execScript("var "+b[0]);for(var e;b.length&&(e=b.shift());)b.length||void 0===c?d[e]?d=d[e]:d=d[e]={}:d[e]=c}
;var q=window.yt&&window.yt.config_||window.ytcfg&&window.ytcfg.data_||{};p("yt.config_",q);p("yt.tokens_",window.yt&&window.yt.tokens_||{});var r=window.yt&&window.yt.msgs_||g("window.ytcfg.msgs")||{};p("yt.msgs_",r);function t(){this.g=this.g;this.l=this.l}
t.prototype.g=!1;t.prototype.isDisposed=function(){return this.g};
t.prototype.dispose=function(){this.g||(this.g=!0,this.m())};
t.prototype.m=function(){if(this.l)for(;this.l.length;)this.l.shift()()};function u(a){t.call(this);this.a=[];this.a[4]=[];this.a[3]=[];this.a[2]=[];this.a[1]=[];this.a[0]=[];a=a||{};this.F=a.timeout||1;this.c={};this.j=u.a;this.A=this.b=this.i=0;this.o=this.h=!1;this.f=[];this.w=l(this.H,this);this.D=l(this.J,this);this.B=l(this.G,this);this.C=l(this.I,this);this.s=!1;this.v=!!window.requestIdleCallback;(this.u=!!a.useRaf&&!!window.requestAnimationFrame)&&document.addEventListener("visibilitychange",this.w)}
(function(){var a=u;function c(){}
c.prototype=t.prototype;a.L=t.prototype;a.prototype=new c;a.prototype.constructor=a;a.M=function(a,c,e){for(var b=Array(arguments.length-2),d=2;d<arguments.length;d++)b[d-2]=arguments[d];return t.prototype[c].apply(a,b)}})();
u.b=1E3/60;u.c=3E3;u.f=300;u.g=3;u.a=u.b-3;function v(a,c,b,d){++a.A;var e=a.A;a.c[e]=c;a.h&&!d?a.f.push({id:e,K:b}):(a.a[b].push(e),a.o||a.h||(0!=a.b&&w(a)!=a.i&&y(a),a.start()));return e}
function z(a){a.f.length=0;for(var c=4;0<=c;c--)a.a[c].length=0;a.c={};y(a)}
function w(a){for(var c=4;1<=c;c--)if(0<a.a[c].length)return!document.hidden&&a.u?3:2;return 1}
function A(a){try{a()}catch(c){(a=g("yt.logging.errors.log"))&&a(c)}}
u.prototype.G=function(a){var c=void 0;a&&(c=a.timeRemaining());this.s=!0;D(this,c);this.s=!1};
u.prototype.J=function(){D(this)};
u.prototype.I=function(){D(this)};
u.prototype.H=function(){this.b&&(y(this),this.start())};
function D(a,c){y(a);a.h=!0;for(var b=m()+(c||a.j),d=a.a[4];d.length;){var e=d.shift(),n=a.c[e];delete a.c[e];n&&A(n)}if(!(m()>=b)){do{a:{d=a;e=d.s?0:1;for(n=3;n>=e;n--)for(var x=d.a[n];x.length;){var B=x.shift(),C=d.c[B];delete d.c[B];if(C){d=C;break a}}d=null}d&&A(d)}while(d&&m()<b)}a.h=!1;b=0;for(d=a.f.length;b<d;b++)e=a.f[b],a.a[e.K].push(e.id);a.j=u.a;a:{for(b=3;0<=b;b--)if(a.a[b].length){b=!0;break a}b=!1}(b||a.f.length)&&a.start();a.f.length=0}
u.prototype.start=function(){this.o=!1;if(0==this.b)switch(this.i=w(this),this.i){case 1:var a=this.B;this.b=this.v?window.requestIdleCallback(a,{timeout:3E3}):window.setTimeout(a,300);break;case 2:this.b=window.setTimeout(this.D,this.F);break;case 3:this.b=window.requestAnimationFrame(this.C)}};
function y(a){if(a.b){switch(a.i){case 1:var c=a.b;a.v?window.cancelIdleCallback(c):window.clearTimeout(c);break;case 2:window.clearTimeout(a.b);break;case 3:window.cancelAnimationFrame(a.b)}a.b=0}}
u.prototype.m=function(){z(this);y(this);this.u&&document.removeEventListener("visibilitychange",this.w);u.L.m.call(this)};function E(){var a=g("yt.scheduler.instance.instance_");if(!a||a.isDisposed())a=new u(("scheduler"in q?q.scheduler:void 0)||{}),p("yt.scheduler.instance.instance_",a);return a}
function F(){var a=g("yt.scheduler.instance.instance_");a&&(a&&"function"==typeof a.dispose&&a.dispose(),p("yt.scheduler.instance.instance_",null))}
function G(){z(E())}
var H=g("yt.scheduler.instance.timerIdMap_")||{};function I(a,c,b){if(0==b||void 0===b)return b=void 0===b,-v(E(),a,c,b);var d=window.setTimeout(function(){var b=v(E(),a,c);H[d]=b},b);
return d}
function J(a){var c=E(),b=m();A(a);a=m()-b;c.h||(c.j-=a)}
function K(a){var c=E();if(0>a)delete c.c[-a];else{var b=H[a];b?(delete c.c[b],delete H[a]):window.clearTimeout(a)}}
function L(){E().start()}
function M(){var a=E();y(a);a.o=!0}
;g("yt.scheduler.initialized")||(p("yt.scheduler.instance.dispose",F),p("yt.scheduler.instance.addJob",I),p("yt.scheduler.instance.addImmediateJob",J),p("yt.scheduler.instance.cancelJob",K),p("yt.scheduler.instance.cancelAllJobs",G),p("yt.scheduler.instance.start",L),p("yt.scheduler.instance.pause",M),p("yt.scheduler.initialized",!0));}).call(this);

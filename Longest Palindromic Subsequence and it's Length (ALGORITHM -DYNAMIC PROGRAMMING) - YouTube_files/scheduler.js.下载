(function(){var f=this;function g(a){a=a.split(".");for(var b=f,c;c=a.shift();)if(null!=b[c])b=b[c];else return null;return b}
function h(a,b,c){return a.call.apply(a.bind,arguments)}
function k(a,b,c){if(!a)throw Error();if(2<arguments.length){var d=Array.prototype.slice.call(arguments,2);return function(){var c=Array.prototype.slice.call(arguments);Array.prototype.unshift.apply(c,d);return a.apply(b,c)}}return function(){return a.apply(b,arguments)}}
function l(a,b,c){l=Function.prototype.bind&&-1!=Function.prototype.bind.toString().indexOf("native code")?h:k;return l.apply(null,arguments)}
var m=Date.now||function(){return+new Date};
function n(a,b){var c=a.split("."),d=f;c[0]in d||!d.execScript||d.execScript("var "+c[0]);for(var e;c.length&&(e=c.shift());)c.length||void 0===b?d[e]&&Object.prototype.hasOwnProperty.call(d,e)?d=d[e]:d=d[e]={}:d[e]=b}
;var p=window.yt&&window.yt.config_||window.ytcfg&&window.ytcfg.data_||{};n("yt.config_",p);function q(){this.h=this.h;this.m=this.m}
q.prototype.h=!1;q.prototype.isDisposed=function(){return this.h};
q.prototype.dispose=function(){this.h||(this.h=!0,this.o())};
q.prototype.o=function(){if(this.m)for(;this.m.length;)this.m.shift()()};function u(){return"SCHEDULER_SOFT_STATE_TIMER"in p?p.SCHEDULER_SOFT_STATE_TIMER:800}
;function v(a){q.call(this);this.a=[];this.a[4]=[];this.a[3]=[];this.a[2]=[];this.a[1]=[];this.a[0]=[];a=a||{};this.f=0;this.G=a.timeout||1;this.c={};this.l=v.a;this.w=this.b=this.j=0;this.s=this.i=!1;this.g=[];this.B=l(this.I,this);this.F=l(this.K,this);this.C=l(this.H,this);this.D=l(this.J,this);this.u=!1;this.A=!!window.requestIdleCallback;(this.v=!!a.useRaf&&!!window.requestAnimationFrame)&&document.addEventListener("visibilitychange",this.B)}
(function(){var a=v;function b(){}
b.prototype=q.prototype;a.M=q.prototype;a.prototype=new b;a.prototype.constructor=a;a.N=function(a,b,e){for(var c=Array(arguments.length-2),d=2;d<arguments.length;d++)c[d-2]=arguments[d];return q.prototype[b].apply(a,c)}})();
v.b=1E3/60;v.c=3E3;v.f=300;v.g=3;v.a=v.b-3;function w(a,b,c,d){++a.w;var e=a.w;a.c[e]=b;a.i&&!d?a.g.push({id:e,L:c}):(a.a[c].push(e),a.s||a.i||(0!=a.b&&x(a)!=a.j&&y(a),a.start()));return e}
function z(a){a.g.length=0;for(var b=4;0<=b;b--)a.a[b].length=0;a.c={};y(a)}
function x(a){for(var b=4;b>=a.f;b--)if(0<a.a[b].length)return 0<b?!document.hidden&&a.v?3:2:1;return 0}
function A(a){try{a()}catch(b){(a=g("yt.logging.errors.log"))&&a(b)}}
v.prototype.H=function(a){var b=void 0;a&&(b=a.timeRemaining());this.u=!0;B(this,b);this.u=!1};
v.prototype.K=function(){B(this)};
v.prototype.J=function(){B(this)};
v.prototype.I=function(){this.b&&(y(this),this.start())};
function B(a,b){y(a);a.i=!0;for(var c=m()+(b||a.l),d=a.a[4];d.length;){var e=d.shift(),r=a.c[e];delete a.c[e];r&&A(r)}d=a.u?0:1;d=a.f>d?a.f:d;if(!(m()>=c)){do{a:{for(var e=a,r=d,t=3;t>=r;t--)for(var D=e.a[t];D.length;){var E=D.shift(),F=e.c[E];delete e.c[E];if(F){e=F;break a}}e=null}e&&A(e)}while(e&&m()<c)}a.i=!1;c=0;for(d=a.g.length;c<d;c++)e=a.g[c],a.a[e.L].push(e.id);a.l=v.a;a:{for(c=3;0<=c;c--)if(a.a[c].length){c=!0;break a}c=!1}(c||a.g.length)&&a.start();a.g.length=0}
v.prototype.start=function(){this.s=!1;if(0==this.b)switch(this.j=x(this),this.j){case 1:var a=this.C;this.b=this.A?window.requestIdleCallback(a,{timeout:3E3}):window.setTimeout(a,300);break;case 2:this.b=window.setTimeout(this.F,this.G);break;case 3:this.b=window.requestAnimationFrame(this.D)}};
function y(a){if(a.b){switch(a.j){case 1:var b=a.b;a.A?window.cancelIdleCallback(b):window.clearTimeout(b);break;case 2:window.clearTimeout(a.b);break;case 3:window.cancelAnimationFrame(a.b)}a.b=0}}
v.prototype.o=function(){z(this);y(this);this.v&&document.removeEventListener("visibilitychange",this.B);v.M.o.call(this)};function C(){var a=g("yt.scheduler.instance.instance_");if(!a||a.isDisposed())a=new v(("scheduler"in p?p.scheduler:void 0)||{}),n("yt.scheduler.instance.instance_",a);return a}
function G(){var a=g("yt.scheduler.instance.instance_");a&&(a&&"function"==typeof a.dispose&&a.dispose(),n("yt.scheduler.instance.instance_",null))}
function H(){z(C())}
var I=g("yt.scheduler.instance.timerIdMap_")||{};function J(a,b,c){if(0==c||void 0===c)return c=void 0===c,-w(C(),a,b,c);var d=window.setTimeout(function(){var c=w(C(),a,b);I[d]=c},c);
return d}
function K(a){var b=C(),c=m();A(a);a=m()-c;b.i||(b.l-=a)}
function L(a){var b=C();if(0>a)delete b.c[-a];else{var c=I[a];c?(delete b.c[c],delete I[a]):window.clearTimeout(a)}}
var M=0,N=0;function O(a){var b=g("ytcsi.tick");b&&b(a)}
function P(){O("jse");Q()}
function Q(){window.clearTimeout(M);C().start()}
function R(){var a=C();y(a);a.s=!0;window.clearTimeout(M);M=window.setTimeout(P,u())}
function S(){window.clearTimeout(N);N=window.setTimeout(function(){O("jset");T(0)},u())}
function T(a){S();var b=C();b.f=a;b.start()}
function U(a){S();var b=C();b.f>a&&(b.f=a,b.start())}
;g("yt.scheduler.initialized")||(n("yt.scheduler.instance.dispose",G),n("yt.scheduler.instance.addJob",J),n("yt.scheduler.instance.addImmediateJob",K),n("yt.scheduler.instance.cancelJob",L),n("yt.scheduler.instance.cancelAllJobs",H),n("yt.scheduler.instance.start",Q),n("yt.scheduler.instance.pause",R),n("yt.scheduler.instance.setPriorityThreshold",T),n("yt.scheduler.instance.enablePriorityThreshold",U),n("yt.scheduler.initialized",!0));}).call(this);

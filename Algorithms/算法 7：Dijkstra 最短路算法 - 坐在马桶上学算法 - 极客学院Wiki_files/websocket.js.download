var jkWebSocket = jkWebSocket || {};
var protocol = 'https:' == document.location.protocol ? 'https://' : 'http://';
var wsprotocol = 'https:' == document.location.protocol ? 'wss://' : 'ws://';

jkWebSocket = {
    adress: wsprotocol + "comet.jikexueyuan.com",
    flash: protocol + "e.jikexueyuan.com/headerandfooter/js/WebSocketMain.swf",
    init: function() {
//      this.unread();
//      this.bind();
     this.creatMessage();
//      this.setMessageBox(); // 非登录状态点击消息图标弹出登录框
    },
    bind: function() {
        $('#messagebox').bind("click", this.massageShow);
        $('.set-read').bind("click", this.setread);
        // 新版消息盒子
        $(document).on('click', this.closeMessageBox); // 关闭
        $('#openNoti').on('click', this.openMessageBox); // 打开
        $('#setRead').on('click', this.setAllRead); // 全设置为已读
        $('#newMessageBox .message-list').on('click', 'a', this.setOneRead); // 单个已读
    },
    setMessageBox: function() {
        var uid = $.cookie('uid');
        if (uid) {
            $('#openNoti').removeClass('diaLoginBtn');
        }
    },
    //首次显示未读信息
    unread: function() {
        var uid = $.cookie('uid');
        var unreadCount = $("#openNoti .unread-count"); // 新版消息盒子
        var numId = $('.unread-num'); // 就业班消息盒子
        var time = new Date().getTime();
        $.ajax({
            type: "get",
            data: { 'type': 'jsonp', 'uid': uid, 't': time },
            url: protocol + "www.jikexueyuan.com/message/v1/unread?callback=?",
            success: function(data) {
                if (data.code == 200) {
                    if (data.data.unread_num != 0) {

                        $('#messagebox').removeClass('my-massage2').addClass('my-massage');
                        unreadCount.show();

                        if (data.data.unread_num > 99) {
                            numId.html('99+');
                            unreadCount.html('99+');
                        } else {
                            numId.html(data.data.unread_num);
                            unreadCount.html(data.data.unread_num);
                        }

                        $('.bounce1,.bounce2,.bounce3').css("display", "inline-block");
                        $('.news-list').show();
                        $('.nonews').hide()
                        $('#this-news').height(350);
                    } else {
                        $('#messagebox').removeClass('my-massage').addClass('my-massage2');
                        unreadCount.hide();
                        numId.html("&nbsp;");
                        unreadCount.html("&nbsp;");
                        $('.set-read').hide();
                        $('.news-list').empty().hide();
                        $('#this-news>h3>span').hide();
                        $('.nonews').show();
                        $('#this-news').css("height", "auto");
                        $('.bounce1,.bounce2,.bounce3').hide();
                    }
                } else {
                    //                  console.log(data.msg) //上线的时候记得屏蔽
                }
            },
            dataType: "jsonp",
            error: function() {
                //              console.log("网络错误")
            }
        });
    },
    closeMessageBox: function(e) {
        var messageBox = $('#newMessageBox');
        if (!messageBox.hasClass('open') && $(e.target).closest('.messagebox').length >= 1) {
            return };
        if (messageBox.hasClass('open') && $(e.target).closest('.messagebox').length < 1) {
            messageBox.slideUp(200);
            messageBox.removeClass('open');
        }
    },
    openMessageBox: function() {
        var messageBox = $('#newMessageBox');
        if (messageBox.hasClass('open')) {
            messageBox.slideUp(200);
            messageBox.removeClass('open');
            return
        };
        $('#newMessageBox .message-list p').remove();
        $('#spinner').show();
        $('#newMessageBox .no-message').hide();
        var uid = $.cookie('uid');
        setTimeout(function() {
            messageBox.fadeIn(300);
            messageBox.addClass('open');
        }, 100)
        $.ajax({
            type: "get",
            url: protocol + "www.jikexueyuan.com/message/v1/unread_list?callback=?",
            success: function(res) {
                if (res.code == 200) {
                    if (res.data.total_items > 0) {
                        var targetDom = $('#newMessageBox .message-list');
                        var content = res.data.list.map(function(item) {
                            var html = '<p ';
                            html += 'msg_id="';
                            html += item.msg_id;
                            html += '">';
                            html += item.content;
                            html += '</p>';
                            return html
                        })
                        $('.message-list').css('height', '250px');
                        $('#spinner').hide();
                        // 当大于99条未读消息的时候
                        if (res.data.total_items > 99) {
                            $("#openNoti .unread-count").html('99+').show();
                        } else {
                            $("#openNoti .unread-count").html(res.data.total_items).show();
                        }
                        $('#setRead').show();
                        targetDom.prepend(content);
                    } else {
                        $('.message-list').css('height', '170px');
                        $('#spinner').hide();
                        $('#newMessageBox .no-message').show();
                        $('#setRead').hide();
                        $("#openNoti .unread-count").html('').hide();
                    }
                } else {
                    console.log(res)
                }
            },
            data: { 'type': 'jsonp', 'uid': uid },
            dataType: "jsonp",
            error: function() {
                console.log("网络错误")
            }
        })
    },
    setAllRead: function() {
        var readList = $('#newMessageBox .message-list p');
        if (readList.length < 1) {
            return false };
        var uid = $.cookie('uid');
        var ids = '-1';
        $.ajax({
            type: 'get',
            url: protocol + "www.jikexueyuan.com/message/v1/read?callback=?",
            data: {
                uid: uid,
                ids: ids,
                type: 'jsonp'
            },
            dataType: 'jsonp',
            success: function(data) {
                if (data.code == 200) {
                    $('#newMessageBox .message-list p').remove();
                    $("#openNoti .unread-count").html('').hide();
                    $('#setRead').hide();
                    $('.message-list').css('height', '170px');
                    $('.no-message').show();
                } else {
                    console.log(data);
                }
            },
            error: function() {
                console.log('网络错误');
            }
        })
    },
    setOneRead: function() {
        var uid = $.cookie('uid');
        var ids = $(this).parent().attr('msg_id');
        $.ajax({
            type: 'get',
            url: protocol + "www.jikexueyuan.com/message/v1/read?callback=?",
            data: {
                uid: uid,
                ids: ids,
                type: 'jsonp'
            },
            dataType: "jsonp",
            success: function(data) {},
            error: function() {
                console.log('网络错误');
            }
        })
    },
    //创建未读消息列表
    creatMessageList: function(data) {
        if (data.data.total_items <= 0) return false;
        $('.nonews').hide()
        var newslist = $('.news-list');
        var data = data.data;

        function createNews(id, murl, contentUrl, name, time, content) {
            var html = '<li msg_id =' + id + ' >';
            html += '<div class="cf">';
            html += '<a class="answer" href=' + murl + ' target = "_blank" >' + name + '</a>';
            html += '<em>' + time + '</em></div>';
            html += '<p><a href=' + contentUrl + ' target = "_blank">' + content + '</a></p>';
            html += '</li>';
            return html;
        }
        for (var i = 0; i < data.list.length; i++) {
            var list = data.list[i];
            var murl = list.extra.title_url;
            var contentUrl = list.extra.content_url;
            var name = list.title;
            var content = list.content;

            var id = list.msg_id;
            var time = jkWebSocket.creatTime(Date.parse((list.created_at).replace(/[-]/g, '/')) / 1000);
            var news = createNews(id, murl, contentUrl, name, time, content);
            newslist.append(news)
        }
        //点击信息打开新页面，标记为已读并删除
        $('.news-list li a').click(function() {
            var id = $(this).parents("li").attr("msg_id");
            var _self = $(this).parents("li");
            var unreadNumber = parseInt($('.unread-num').eq(0).text());
            if (unreadNumber > 0) {
                unreadNumber--;
                $('.unread-num').html(unreadNumber);
            };
            $.ajax({
                type: "get",
                url: protocol + "www.jikexueyuan.com/message/v1/read?callback=?",
                data: {
                    "ids": id,
                    "type": "jsonp"
                },
                success: function(data) {
                    if (data.code == 200) {
                        _self.remove();
                        //                      var unreadNumber = parseInt($('.unread-num').eq(0).text());
                        if (unreadNumber > 0) {
                            //                          unreadNumber--;
                            $('.unread-num').html(unreadNumber);
                        } else {
                            $('.set-read').hide();
                            $('.news-list').empty().hide();
                            $('#this-news>h3>span').hide();
                            $('#this-news').css("height", "auto");
                            $('#messagebox').removeClass('my-massage').addClass('my-massage2');
                            $('.unread-num').html("&nbsp;");
                            $('.nonews').show();
                        }

                    } else {
                        console.log(data.msg) //上线的时候记得屏蔽
                    }
                },
                dataType: "jsonp",
                error: function() {
                    console.log("网络错误")
                }
            });
        })
    },
    //消息时间格式化
    creatTime: function(publishTime) {
        var d_minutes, d_hours, d_days;
        var timeNow = parseInt(new Date().getTime() / 1000);
        var d;
        d = timeNow - publishTime;
        d_days = parseInt(d / 86400);
        d_hours = parseInt(d / 3600);
        d_minutes = parseInt(d / 60);
        if (d_days > 0 && d_days < 4) {
            return d_days + "天前";
        } else if (d_days <= 0 && d_hours > 0) {
            return d_hours + "小时前";
        } else if (d_hours <= 0 && d_minutes > 0) {
            return d_minutes + "分钟前";
        } else if (d_minutes <= 0) {
            return "刚刚";
        } else if (d_days > 4) {
            var s = new Date(publishTime * 1000);
            var Month = s.getMonth() + 1;
            return s.getFullYear() + "年" + Month + "月" + s.getDate() + "日";
        }
    },
    //全部标记为已读
    setread: function() {
        var total = 0;
        var idsAll = [];
        var alength = $('.news-list li').length - 1;
        $('.news-list li').each(function(index) {
            var id = $(this).attr('msg_id');
            idsAll.push(id);
            if (index == alength) {
                var ids = idsAll.join(",")
                $.ajax({
                    type: "get",
                    url: protocol + "www.jikexueyuan.com/message/v1/read?callback=?",
                    data: {
                        "ids": ids,
                        'type': 'jsonp'
                    },
                    success: function(data) {
                        if (data.code == 200) {
                            $('.set-read').hide();
                            $('.news-list').empty().hide();
                            $('#this-news>h3>span').hide();
                            $('#this-news').css("height", "auto");
                            $('#messagebox').removeClass('my-massage').addClass('my-massage2');
                            $('.unread-num').html("&nbsp;");
                            $('.nonews').show();
                        } else {}
                    },
                    dataType: "jsonp",
                    error: function() {
                        console.log("网络错误")
                    }
                });
            }
        })
    },
    //未读信息列表
    messageList: function() {
        $.ajax({
            type: "get",
            url: protocol + "www.jikexueyuan.com/message/v1/unread_list?callback=?",
            success: function(data) {
                if (data.code == 200) {
                    var newslist = $('.news-list');
                    newslist.empty();
                    jkWebSocket.creatMessageList(data);
                } else {}
            },
            data: { 'type': 'jsonp' },
            dataType: "jsonp",
            error: function() {
                console.log("网络错误")
            }
        });
    },
    //动态通信
    messageNumber: null,
    pingTimeout: null, //重连时间间隔
    pingInterval: null, //ping间隔
    messageTime: function(t) { //n秒重新连接
        var that = this;
        var time = parseInt(t) * 1000 || 150000;
        clearInterval(that.messageNumber);
        that.messageNumber = setInterval(function() {
            jkWebSocket.creatMessage()
        }, time)
    },
    creatMessage: function() {
        var that = this;
        clearInterval(that.messageNumber);
        WEB_SOCKET_SWF_LOCATION = jkWebSocket.flash;
        ws = new WebSocket(jkWebSocket.adress); //测试地址，上线需要更新
        ws.onopen = function() {};
        ws.onmessage = function(e) {
            if (e.data == "ping") {
                ws.send("pong"); // Sends a message.
                return;
            }
            that.pingTimeout = e.data.pingTimeout;

            var uid = $.cookie("uid");
            var token = $.cookie("authcode");
            var mydata = {
                "type": "login",
                "data": {
                    "app_id": 1,
                    "from": "web",
                    "uid": uid,
                    "token": encodeURIComponent(token) //转义特殊字符
                }
            };
            var messageData = JSON.parse(e.data);
            switch (messageData.type) {
                case "connect":
                    ws.send(JSON.stringify(mydata)); // Sends a message.
                    break;
                case "auth":
                    var _e = messageData.data.result;
                    if (_e == "ok") return;
                    if (_e == "error") {
                        that.messageTime(that.pingTimeout) //150秒重新连接
                    };
                    break;
                case "notify":
                    var unread_num = messageData.data.unread_num;
                    if (unread_num != 0) {
                        $('#messagebox').removeClass('my-massage2').addClass('my-massage');
                        $('.unread-num').html(unread_num);
                        $('.bounce1,.bounce2,.bounce3').css("display", "inline-block");
                    } else {
                        $('#messagebox').removeClass('my-massage').addClass('my-massage2');
                        $('.unread-num').html("&nbsp;");
                        $('.bounce1,.bounce2,.bounce3').hide();
                    }
                    break;
                default:
                    ws.close();
                    break;
            }
        };
        ws.onerror = function() { //出错
            console.log("error")
        };
        ws.onclose = function() { //通信关闭
            that.messageTime(that.pingTimeout) //150秒重新连接
        };
    },
    massageShow: function() {
        $('#messagebox').unbind("click");
        jkWebSocket.messageList();
        stopEventBubble();
        $('#this-news').slideDown(200, function() {
            $(document).bind("click", function() {
                $('#this-news').hide();
                $('#messagebox').unbind("click");
                $('#messagebox').bind("click", jkWebSocket.massageShow);
            })
        });

        $('#this-news').bind("click", function() {
            stopEventBubble();
        })
    }

}
$(function() {
    var uid = $.cookie("uid");
    if (uid) {
        jkWebSocket.init();
    } else {
        //console.log("未登录")
    }
})

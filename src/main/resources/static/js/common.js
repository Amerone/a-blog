//1.创建一个scrollReveal对象
window.sr = ScrollReveal();
//2.调用scrollReveal里的reveal方法将scrollReveal内部的动画和css中的标签关联起来
sr.reveal('.scroll', config);
//参数一：跟html标签关联的类名
//参数二：动画配置
var config = {
    reset: true,   // 滚动鼠标时，动画开关(默认是false没有打开鼠标滚动的动画开关)
    origin: 'right', // 动画开始的方向
    duration: 2000,   // 动画持续时间
    delay: 0, // 延迟
    rotate: {x: 0, y: 0, z: 0},  // 过度到0的初始角度
    opacity: 0.2, // 初始透明度  (0.2到1的效果)
    scale: 2,       //缩放
    easing: 'ease-in-out', //动画效果// 缓动'ease', 'ease-in-out'，'linear'...
};

var wow = new WOW({
                      boxClass: 'wow',
                      animateClass: 'animated',
                      offset: 0,
                      mobile: true,
                      live: true
                  });
wow.init();

// 封装
(function ($) {
    $.extend({
                 modal: {
                     // 显示图标
                     icon: function (type) {
                         var icon = "";
                         if (type == modal_status.WARNING) {
                             icon = 0;
                         } else if (type == modal_status.SUCCESS) {
                             icon = 1;
                         } else if (type == modal_status.FAIL) {
                             icon = 2;
                         } else {
                             icon = 3;
                         }
                         return icon;
                     },
                     // 消息提示
                     msg: function (content, type) {
                         if (type != undefined) {
                             layer.msg(content, {icon: $.modal.icon(type), time: 1000, shift: 5});
                         } else {
                             layer.msg(content);
                         }
                     },
                     // 错误消息
                     msgError: function (content) {
                         $.modal.msg(content, modal_status.FAIL);
                     },
                     // 成功消息
                     msgSuccess: function (content) {
                         $.modal.msg(content, modal_status.SUCCESS);
                     },
                     // 警告消息
                     msgWarning: function (content) {
                         $.modal.msg(content, modal_status.WARNING);
                     },
                     // 弹出提示
                     alert: function (content, type) {
                         layer.alert(content, {
                             icon: $.modal.icon(type),
                             title: "系统提示",
                             btn: ['确认'],
                             btnclass: ['btn btn-primary'],
                         });
                     },
                     // 消息提示并刷新父窗体
                     msgReload: function (msg, type) {
                         layer.msg(msg, {
                                       icon: $.modal.icon(type),
                                       time: 500,
                                       shade: [0.1, '#8F8F8F']
                                   },
                                   function () {
                                       $.modal.reload();
                                   });
                     },
                     // 错误提示
                     alertError: function (content) {
                         $.modal.alert(content, modal_status.FAIL);
                     },
                     // 成功提示
                     alertSuccess: function (content) {
                         $.modal.alert(content, modal_status.SUCCESS);
                     },
                     // 警告提示
                     alertWarning: function (content) {
                         $.modal.alert(content, modal_status.WARNING);
                     },
                     // 关闭窗体
                     close: function () {
                         var index = parent.layer.getFrameIndex(window.name);
                         parent.layer.close(index);
                     },
                     // 关闭全部窗体
                     closeAll: function () {
                         layer.closeAll();
                     },
                     // 确认窗体
                     confirm: function (content, callBack) {
                         layer.confirm(content, {
                             icon: 3,
                             title: "系统提示",
                             btn: ['确认', '取消'],
                             btnclass: ['btn btn-primary', 'btn btn-danger'],
                         }, function (index) {
                             layer.close(index);
                             callBack(true);
                         });
                     },
                     // 弹出层指定宽度
                     open: function (title, url, width, height, callback) {
                         //如果是移动端，就使用自适应大小弹窗
                         if (navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)) {
                             width = 'auto';
                             height = 'auto';
                         }
                         if ($.common.isEmpty(title)) {
                             title = false;
                         }
                         ;
                         if ($.common.isEmpty(url)) {
                             url = "/404.html";
                         }
                         ;
                         if ($.common.isEmpty(width)) {
                             width = 800;
                         }
                         ;
                         if ($.common.isEmpty(height)) {
                             height = ($(window).height() - 50);
                         }
                         ;
                         if ($.common.isEmpty(callback)) {
                             callback = function (index, layero) {
                                 var iframeWin = layero.find('iframe')[0];
                                 iframeWin.contentWindow.submitHandler();
                             }
                         }
                         layer.open({
                                        type: 2,
                                        area: [width + 'px', height + 'px'],
                                        fix: false,
                                        //不固定
                                        maxmin: true,
                                        shade: 0.3,
                                        title: title,
                                        content: url,
                                        btn: ['确定', '关闭'],
                                        // 弹层外区域关闭
                                        shadeClose: true,
                                        yes: callback,
                                        cancel: function (index) {
                                            return true;
                                        }
                                    });
                     },
                     // 弹出层指定参数选项
                     openOptions: function (options) {
                         var _url = $.common.isEmpty(options.url) ? "/404.html" : options.url;
                         var _title = $.common.isEmpty(options.title) ? "系统窗口" : options.title;
                         var _width = $.common.isEmpty(options.width) ? "800" : options.width;
                         var _height = $.common.isEmpty(options.height) ? ($(window).height() - 50)
                                                                        : options.height;
                         layer.open({
                                        type: 2,
                                        maxmin: true,
                                        shade: 0.3,
                                        title: _title,
                                        fix: false,
                                        area: [_width + 'px', _height + 'px'],
                                        content: _url,
                                        shadeClose: true,
                                        btn: ['<i class="fa fa-check"></i> 确认',
                                              '<i class="fa fa-close"></i> 关闭'],
                                        yes: function (index, layero) {
                                            options.callBack(index, layero)
                                        }, cancel: function () {
                                 return true;
                             }
                                    });
                     },
                     // 弹出层全屏
                     openFull: function (title, url, width, height) {
                         //如果是移动端，就使用自适应大小弹窗
                         if (navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)) {
                             width = 'auto';
                             height = 'auto';
                         }
                         if ($.common.isEmpty(title)) {
                             title = false;
                         }
                         ;
                         if ($.common.isEmpty(url)) {
                             url = "/404.html";
                         }
                         ;
                         if ($.common.isEmpty(width)) {
                             width = 800;
                         }
                         ;
                         if ($.common.isEmpty(height)) {
                             height = ($(window).height() - 50);
                         }
                         ;
                         var index = layer.open({
                                                    type: 2,
                                                    area: [width + 'px', height + 'px'],
                                                    fix: false,
                                                    //不固定
                                                    maxmin: true,
                                                    shade: 0.3,
                                                    title: title,
                                                    content: url,
                                                    btn: ['确定', '关闭'],
                                                    // 弹层外区域关闭
                                                    shadeClose: true,
                                                    yes: function (index, layero) {
                                                        var iframeWin = layero.find('iframe')[0];
                                                        iframeWin.contentWindow.submitHandler();
                                                    },
                                                    cancel: function (index) {
                                                        return true;
                                                    }
                                                });
                         layer.full(index);
                     },
                     // 禁用按钮
                     disable: function () {
                         var doc = window.top == window.parent ? window.document
                                                               : window.parent.document;
                         $("a[class*=layui-layer-btn]", doc).addClass("layer-disabled");
                     },
                     // 启用按钮
                     enable: function () {
                         var doc = window.top == window.parent ? window.document
                                                               : window.parent.document;
                         $("a[class*=layui-layer-btn]", doc).removeClass("layer-disabled");
                     },
                     // 打开遮罩层
                     loading: function (message) {
                         $.blockUI({
                                       message: '<div class="loaderbox"><div class="loading-activity"></div> '
                                                + message + '</div>'
                                   });
                     },
                     // 关闭遮罩层
                     closeLoading: function () {
                         setTimeout(function () {
                             $.unblockUI();
                         }, 50);
                     },
                     // 重新加载
                     reload: function () {
                         parent.location.reload();
                     }
                 },
                 // 通用方法封装处理
                 common: {
                     // 判断字符串是否为空
                     isEmpty: function (value) {
                         if (value == null || this.trim(value) == "") {
                             return true;
                         }
                         return false;
                     },
                     // 判断一个字符串是否为非空串
                     isNotEmpty: function (value) {
                         return !$.common.isEmpty(value);
                     },
                     // 空对象转字符串
                     nullToStr: function (value) {
                         if ($.common.isEmpty(value)) {
                             return "-";
                         }
                         return value;
                     },
                     // 是否显示数据 为空默认为显示
                     visible: function (value) {
                         if ($.common.isEmpty(value) || value == true) {
                             return true;
                         }
                         return false;
                     },
                     // 空格截取
                     trim: function (value) {
                         if (value == null) {
                             return "";
                         }
                         return value.toString().replace(/(^\s*)|(\s*$)|\r|\n/g, "");
                     },
                     // 指定随机数返回
                     random: function (min, max) {
                         return Math.floor((Math.random() * max) + min);
                     },
                     startWith: function (value, start) {
                         var reg = new RegExp("^" + start);
                         return reg.test(value)
                     },
                     endWith: function (value, end) {
                         var reg = new RegExp(end + "$");
                         return reg.test(value)
                     }
                 }

             });
})(jQuery);

/** 消息状态码 */
web_status = {
    SUCCESS: 200,
    FAIL: 500
};

/** 弹窗状态码 */
modal_status = {
    SUCCESS: "success",
    FAIL: "error",
    WARNING: "warning"
};
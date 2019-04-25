layui.use('flow', function () {
    var $ = layui.jquery; //不用额外加载jQuery，flow模块本身是有依赖jQuery的，直接用即可。
    var flow = layui.flow;
    flow.load({
                  elem: '#synthesize' //指定列表容器
                  ,isAuto: false
                  ,isLazyimg: true
                  , done: function (page, next) { //到达临界点（默认滚动触发），触发下一页
            var lis = [];
            //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
            $.get('/article/synthesize?page=' + page, function (res) {
                //假设你的列表返回在data集合中
                layui.each(res.content, function (index, item) {
                    lis.push(
                        '<li class="scroll">' + '<a href="' + item.avatar + '" class="fly-avatar"> <img src="'
                        + item.avatar + '" alt="' + item.userName + '" /> </a>' +
                        '<h2> <a class="layui-badge">分享</a> <a href="/article/detail/'+item.id+'">'
                        + item.title + '</a>  </h2>' +
                        '<div class="fly-list-info"> <a href="user/home.html" link> <cite>'
                        + item.userName + '</cite> </a> <span>' + item.updateDate
                        + '</span> <span class="fly-list-nums"><i class="iconfont icon-pinglun1" title="回答"></i> '+item.viewCount+'</span> </div>'
                        +
                        '<div class="fly-list-badge"></div>' +
                        '</li>');
                });

                //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                next(lis.join(''), page < res.totalPages);
            });
        }
              });

    flow.load({
                  elem: '#topArticle' //指定列表容器
                  ,isAuto: false
                  ,isLazyimg: true
                  , done: function (page, next) { //到达临界点（默认滚动触发），触发下一页
            var lis = [];
            //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
            $.get('/article/top?page=' + page, function (res) {
                //假设你的列表返回在data集合中
                layui.each(res.content, function (index, item) {
                    lis.push(
                        '<li class="scroll">' + '<a href="' + item.avatar + '" class="fly-avatar"> <img src="'
                        + item.avatar + '" alt="' + item.userName + '" /> </a>' +
                        '<h2> <a class="layui-badge">分享</a> <a href="/article/detail/'+item.id+'">'
                        + item.title + '</a>  </h2>' +
                        '<div class="fly-list-info"> <a href="user/home.html" link> <cite>'
                        + item.userName + '</cite> </a> <span>' + item.updateDate
                        + '</span> <span class="fly-list-nums"><i class="iconfont icon-pinglun1" title="回答"></i> '+item.viewCount+'</span> </div>'
                        +
                        '<div class="fly-list-badge"></div>' +
                        '</li>');
                });

                //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                next(lis.join(''), page < res.totalPages);
            });
        }
              });



    flow.load({
                  elem: '#hotArticle' //指定列表容器
                  ,isAuto: true
                  , isLazyimg: true
                  , done: function (page, next) { //到达临界点（默认滚动触发），触发下一页
            var lis = [];
            //以jQuery的Ajax请求为例，请求下一页数据（注意：page是从2开始返回）
            $.get('/article/hot?page=' + page, function (res) {
                //假设你的列表返回在data集合中
                layui.each(res.content, function (index, item) {
                    lis.push(
                        '<dd class="scroll">' +
                        '<a href="jie/detail.html">'+item.title+'</a>'+
                        '<span><i class="iconfont icon-pinglun1"></i> '+item.viewCount+'</span>');
                });

                //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                next(lis.join(''), page < res.totalPages);
            });
        }
              });

});
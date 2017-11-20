/**
 * Created by Administrator on 2017/11/3.
 */

var my = {
    getSoftWareList: function(){
        /*$.ajax({
         url: "",
         type: "get",
         dataType: "json",
         success: function(res){
         var res = resultData;
         var list = res.replyDisInfo;
         var totalFlow = res.sums[0].totalFlow;
         var groupCount = res.sums[0].groupCount;
         var $wrap = $(".mid-inner-mid .rows-wrap");

         $wrap.html("");
         $("#totalAppNum").text(groupCount);
         $.each(list,function(i,item){
         var $template = $($(".template-row").html());
         var vals = $template.find("[data-key]").attr("data-key");
         var percent = (item.groupTotalFlow/totalFlow * 100).toFixed(2);

         $template.data("groupDetail",item.groupDetail);
         $template.find("[data-key='percent']").text(percent);
         $template.find("[data-appid]").attr("data-appid",item.groupValue);
         for( var k in item){
         $template.find("[data-key=" + k + "]").text(item[k]);
         }
         if( [0,1,2].indexOf(i) != -1 ){
         $template.find(".app-icon-default").addClass("app-icon");
         }
         if( i%2 != 0 ){
         $template.addClass("even");
         }
         $wrap.append($template);
         });
         $wrap.find(".row:first-child").trigger("click");
         },
         error: function(){
         alert("获取信息失败")
         }
         })*/

        var res = resultData;
        var list = res.replyDisInfo;
        var totalFlow = res.sums[0].totalFlow;
        var groupCount = res.sums[0].groupCount;
        var $wrap = $(".mid-inner-mid .rows-wrap");

        $wrap.html("");
        $("#totalAppNum").text(groupCount);
        $.each(list,function(i,item){
            var $template = $($(".template-row").html());
            var vals = $template.find("[data-key]").attr("data-key");
            var percent = (item.groupTotalFlow/totalFlow * 100).toFixed(2);

            $template.data("groupDetail",item.groupDetail);
            $template.find("[data-key='percent']").text(percent);
            $template.find("[data-appid]").attr("data-appid",item.groupValue);
            for( var k in item){
                $template.find("[data-key=" + k + "]").text(item[k]);
            }
            if( i == 0 || i == 1 || i== 2 ){
                $template.find(".app-icon-default").addClass("app-icon");
            }
            if( i%2 != 0 ){
                $template.addClass("even");
            }
            $wrap.append($template);
        });
        $wrap.find(".row:first-child").trigger("click");
    },
    setScrollPanelHeight: function(){
        var windowH = $(window).height();
        var $scrollBox = $(".mid-inner-mid");
        var $fixed = $(".fixed-foot");
        var scrollH = windowH - 34;
        $("body").css("height",windowH+"px");
        $scrollBox.css("height",scrollH + "px");
        $fixed.css("top",scrollH-5);
    },
    preventBubble: function(e){
        if (e && e.stopPropagation) {
            // this code is for Mozilla and Opera
            e.stopPropagation();
        } else if (window.event) {
            // this code is for IE
            window.event.cancelBubble = true;
        }
    },
    getDisagreeList: function(){
       /* $.ajax({
            url: "",
        })*/
        var data = disagreeList.reasonList;
        var html = "";
        $.each(data,function(i,item){
            html += '<li>';
            html +=     i == 0?'<input type="radio" id="'+item.reasonId+'" name="reasons" checked="checked"/>':'<input type="radio" id="'+item.reasonId+'" name="reasons"/>';
            html +=     '<label for="'+item.reasonId+'">'+item.reasonName+'</label>';
            html +=     '<p class="float-box">'+item.detail+'</p>';
            html += '</li>';
        });
        $(".popup-ul").html(html);
    },
    getUrlParams: function() {
                    var url = window.location.search,
                        urlParams = {};
                    if (url.indexOf("?") != -1) {
                        var str = url.substr(1),
                            arr = str.split("&");
                        for( var i=0;i<arr.length;i++ ){
                            var p = arr[i].split("=");
                            if( p[1] ){
                                urlParams[p[0]] = p[1];
                            }
                        }
                    }
                    return urlParams;
                },
    getDecryptUserInfo: function(){
       var params = my.getUrlParams();
        $.ajax({
            url: "./onlineLog/compGprsBill",
            type: "post",
            data:JSON.stringify(params),
            contentType:"application/json;charset=UTF-8",
            success: function (res) {
                if( res.code != 0 ){
                    alert("请求失败了！");
                    return
                }
                var data = res.data.overviewUse1;
                for( var k in data ){
                    var $elem = $("#"+k);
                    if( $elem.length ){
                        $elem.attr("type") == "hidden"?$elem.val(data[k]):$elem.text(data[k]);
                    }
                }

            },
            error: function(){
                alert("请求失败！")
            }
        });
    }
}

$(function(){
    //展开全部
    $(".j-loadAll").on("click",function(){
        var $midFoot = $(this).parent();
        $midFoot.hide();
        $(".mid-inner-mid").addClass("inner-midbox-scroll");
    });
    //点击“不认可”按钮
    $(".j-disagree").on("click",function(){
        var $popup = $(".popupBox");
        $popup.show();
    });
    //确定、取消按钮
    $(".j-ensure").on("click",function(){
        $(".popupBox").hide();
    });
    $(".j-cancel").on("click",function(){
        $(".popupBox").hide();
    })
    //点击展示某个软件详细介绍
    $(".rows-wrap").on("click",".row",function(){
        var $this = $(this);
        var $detailPanel = $(".righter");
        var $icon = $this.find(".app-icon-default");
        var appName = $this.find("[data-key='groupValueName']").text();
        var groupDetail = $this.data("groupDetail");

        $this.addClass("selected").siblings(".selected").removeClass("selected");
        if( $icon.hasClass("app-icon") ){
            $detailPanel.find(".app-icon-default").addClass("app-icon");
        }else{
            $detailPanel.find(".app-icon-default").removeClass("app-icon");
        }
        $detailPanel.find(".detail-name").text(appName);
        $detailPanel.find(".righter-content>p").text(groupDetail);
    });
    //不认可原因 列表，鼠标滑动，显示悬浮框
    $(".popup-ul").on({
        mouseenter: function(){
            var $this = $(this);
            $this.next("p.float-box").show();
        },
        mouseleave:function(){
            var $this = $(this);
            $this.next("p.float-box").hide();
        }
    },"label");
});

window.onload = my.setScrollPanelHeight;
window.onresize = my.setScrollPanelHeight;

$(document).ready(function(){
    my.getDecryptUserInfo();
    my.getSoftWareList();
    my.getDisagreeList();
});

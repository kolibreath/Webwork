function homepage(call) {
    let allData = {};

    //请求banner 数据
    let bannerRequest= $.ajax(({
        url:"/banner/all",
        type:"GET",
        success:function(result){
            allData.banner = result;
            console.log(result);
        },
        error:function (result) {
            allData.banner = result;
        },
        complete:function (result) {
            // completeFunction(result)
        }
    }));

    //请求帖子数据
    let postRequest = $.ajax(({
        url:"/post/all",
        type:"GET",
        success:function (result) {
            allData.post = result;
        },
        error:function (result) {
            allData.post = result;
        },
        complete:function (result) {
            // completeFunction(result);
        }
    }));

    $.when(postRequest, bannerRequest).done(() => {call(allData)});
}



function getMyPost(call){
    let allData = {};
    console.log("执行 get my post");
    let post =$.ajax(({
        url:"post/my_post/",
        type:"GET",
        success:function(result){
            allData = result;
            console.log(result);
        },
        //todo 错误处理
        error:function (result) {

        },
        complete:function (result) {

        }
    }));

    $.when(post).done(() =>{call(allData)});

}

function getPostByGameId(gameId,call){
    let allData = {};
    let post =$.ajax(({
        url:"post/user/"+gameId,
        type:"GET",
        success:function(result){
            allData.post = result;
        },
        //todo 错误处理
        error:function (result) {

        },
        complete:function (result) {

        }
    }));

    $.when(post).done(() =>{call(allData)});

}
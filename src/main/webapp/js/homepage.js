window.onload = function () {
  data_rili_time();
  this.setInterval("data_rili_time()", 1000);
  ajax_invitation();
};

//日历的更新
function data_rili_time() {
  var data = new Date();
  // console.log(data.getFullYear());
  document.getElementsByClassName(
    "data_rili"
  )[0].innerHTML = `${data.getFullYear()}-${data.getMonth()}-${data.getDate()} ${data.getHours()}:${data.getMinutes()}:${data.getSeconds()}`;
}

//关于帖子的属性注入
function post_area_entity(data) {
  for (var x = 0; x < data.length; x++) {
    //		console.log(data[x]);
    var divfa = newdiv(
      document.getElementById("invitation_area"),
      "post_area_entity"
    );
    divfa.id = data[x]["number"];
    divfa.onclick = lookinvitation;
    newh(divfa, "title", data[x]["title"], "3");
    newp(divfa, "subtitle", data[x]["subtitle"]);
    newp(divfa, "post_data", data[x]["time"]);
    newp(divfa, "post_data", `作者:${data[x]["name"]}`);
    //	    newp(divfa, "post_data", "4");
  }
}

//看帖子转发连接
function lookinvitation() {
  var url = `http://localhost:8080/maven/core/article.html?id=${this.id}`;
  window.open(url);
}

//关于账号的属性注入
function data_uesr(data) {
  if (data != null) {
    //		 	console.log(data);
    document.getElementById("name").innerHTML = data["name"];
    document.getElementById("personality").innerHTML = data["personality"];
    document.getElementById("state").innerHTML = data["name"];
    document.getElementById("state_enroll").innerHTML = "退出登录";
  } else {
    document.getElementById("name").innerHTML = "未登录";
    document.getElementById("personality").innerHTML = "";
    document.getElementById("state").innerHTML = "未登录";
    document.getElementById("state_enroll").innerHTML = "登录";
  }
}

//关于粉丝和关注的注入
function data_follow(follow, coverfollow) {
  if (follow) {
    document.getElementById("follow").innerHTML = follow;
    document.getElementById("fans").innerHTML = coverfollow;
  }
}
//
function data_myinvitation(myinvitations) {
  if (myinvitations) {
    //		  console.log(myinvitations);
    document.getElementById("invitation").innerHTML = myinvitations.length;
    myinvitations.forEach((item, indes) => {
      var li = newli(
        document.getElementById("myinvitations"),
        "list-group-item"
      );
      newp(li, "my_0_name", item.title);
      newp(li, "my_0_data", item.time);
      //	        if(indes>5)break;
    });
  }
}

function ajax_invitation() {
  $.ajax({
    tyep: "post",
    url: "http://localhost:8080/maven/operation/invitations",
    contentType: "application/json;charset=UTF-8",
    data: {},
    dataType: "json", //返回的数据类型格式
    success: function (data) {
      //    	console.log(data);
      data_uesr(data["user"]);
      post_area_entity(data["invitation"]);
      data_follow(data["follow"], data["coverfollows"]);
      data_myinvitation(data["myinvitations"]);
    },
    error: function () {
      //请求出错处理
      alert("请求出现错误，请重新尝试");
    },
  });
}

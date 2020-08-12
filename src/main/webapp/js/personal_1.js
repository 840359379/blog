window.onload = function () {
  ajax_invitation();
};

//关于帖子的属性注入
function post_area_entity(data) {
  if (data) {
    //		  console.log(myinvitations);
    document.getElementById("invitation").innerHTML = data.length;
    for (var x = 0; x < data.length; x++) {
      //		console.log(data[x]);

      var divfa = newdiv(document.getElementById("invitation_area"), "number");
      divfa.id = data[x]["number"];
      divfa.onclick = lookinvitation;
      newimg(divfa, "portrait format", "");
      var div = newdiv(divfa, "user_1");
      newp(div, "name", "");
      newp(div, "time", data[x]["time"]);
      newh(divfa, "", data[x]["title"], "3");
      newp(divfa, "", data[x]["subtitle"]);
    }
  }
}

//看帖子转发连接
function lookinvitation() {
  var url = `http://localhost:8080/maven/core/article.html?id=${this.id}`;
  window.open(url);
}

//关于账号的属性注入
function data_uesr(uesr) {
  var changes = document.getElementsByName("changes");
  if (uesr) {
    document.getElementById("state").innerHTML = uesr.name;
    document.getElementById("state_enroll").innerHTML = "退出登录";
    document.getElementsByClassName(
      "name"
    )[0].innerHTML = `${uesr.name}的放松区`;
    // changes[0].value = uesr.name;
    for (var x = 1; x < document.getElementsByClassName("name").length; x++) {
      document.getElementsByClassName("name")[x].innerHTML = uesr.name;
    }
    document.getElementsByClassName(
      "personality"
    )[0].innerHTML = `个性签名：${uesr.personality}`;
    // changes[4].value = uesr.personality;
    document.getElementsByClassName("personality")[1].innerHTML =
      uesr.personality;
    for (
      var x = 0;
      x < document.getElementsByClassName("portrait").length;
      x++
    ) {
      document.getElementsByClassName("portrait")[x].src = uesr.portrait;
    }
  } else {
    document.getElementsByClassName("name")[0].innerHTML = "放松区";
  }
}

//关于粉丝和关注的注入
function data_follow(follow, coverfollow) {
  if (follow) {
    document.getElementById("follow").innerHTML = follow;
    document.getElementById("fans").innerHTML = coverfollow;
  }
}

//获取资料的ajax
function ajax_invitation() {
  $.ajax({
    tyep: "post",
    url: "http://localhost:8080/maven/personal/my",
    contentType: "application/json;charset=UTF-8",
    data: {},
    dataType: "json", //返回的数据类型格式
    success: function (data) {
      //    	console.log(data);
      post_area_entity(data["invitation"]);
      data_uesr(data["user"]);
      data_follow(data["follow"], data["coverfollows"]);
    },
    error: function () {
      //请求出错处理
      alert("未登录，或则登录已过期");
    },
  });
}

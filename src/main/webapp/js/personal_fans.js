window.onload = function () {
  ajax_invitation();
};

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

// 粉丝的属性注入
function data_follow(follow) {
  // console.log(follow);
  if (follow) {
    follow.forEach((element) => {
      var fa = newdiv(document.getElementById("invitation_area"), "follow");
      newimg(fa, "follow_format", "../picture/timg.jpg");
      newp(fa, "follow_name", element.name);
      newbutton(fa, "btn btn-secondary follow_button", "删除");
    });
  }
}

function ajax_invitation() {
  $.ajax({
    tyep: "post",
    url: "http://localhost:8080/maven/personal/fans",
    contentType: "application/json;charset=UTF-8",
    data: {},
    dataType: "json", //返回的数据类型格式
    success: function (data) {
      //    	console.log(data);
      if (data) {
        data_uesr(data["user"]);
        data_follow(data["follow"]);
      } else {
        alert("未登录");
      }
    },
    error: function () {
      //请求出错处理
      alert("未登录，或则登录已过期");
    },
  });
}

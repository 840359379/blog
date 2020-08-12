window.onload = function () {
  document.getElementById("send").onclick = send;
  ajax_invitation();
};

function send() {
  var title = document.getElementById("title").value;
  var subtitle = document.getElementById("subtitle").value;
  var content = document.getElementById("content").innerHTML;
  console.log(content);
  $.ajax({
    tyep: "POST",
    url: "http://localhost:8080/maven/personal/sand",
    // contentType: "application/x-www-form-urlencoded",
    //    contentType: "application/json;charset=UTF-8",
    data: { title: title, subtitle: subtitle, content: content },
    dataType: "json", //返回的数据类型格式
    success: function (data) {
      if (data) {
        alert("成功");
      } else {
        alert("没有登录或登录已过期");
      }
    },
    error: function (data) {
      //未登录的时候
      alert("出现失误");
    },
  });
}
// 用户填充
function data_uesr(uesr) {
  var changes = document.getElementsByName("changes");
  if (uesr) {
    document.getElementById("state").innerHTML = uesr.name;
    document.getElementById("state_enroll").innerHTML = "退出登录";
    document.getElementsByClassName(
      "name"
    )[0].innerHTML = `${uesr.name}的放松区`;
    document.getElementsByClassName(
      "personality"
    )[0].innerHTML = `个性签名：${uesr.personality}`;
  } else {
    document.getElementsByClassName("name")[0].innerHTML = "放松区";
  }
}

function ajax_invitation() {
  $.ajax({
    tyep: "get",
    url: "http://localhost:8080/maven/personal/uesr",
    contentType: "application/x-www-form-urlencoded",
    //    contentType: "application/json;charset=UTF-8",
    data: {},
    dataType: "json", //返回的数据类型格式
    success: function (data) {
      data_uesr(data);
    },
    error: function () {
      //未登录的时候
      document.getElementsByClassName("name")[0].innerHTML = "放松区";
      document.getElementsByClassName("change")[0].className =
        "btn btn-secondary change display_none";
      document.getElementsByClassName("change")[1].className =
        "btn btn-secondary change display_none";
      alert("未登录，或则登录已过期");
    },
  });
}

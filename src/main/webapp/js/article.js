window.onload = function () {
  ajax_invitation();
};

//填充用户数据
function data_uesr(uesr, my) {
  //	console.log(uesr);
  var changes = document.getElementsByName("changes");
  if (uesr) {
    document.getElementById("state").innerHTML = my.name;
    document.getElementById("state_enroll").innerHTML = "退出登录";
    document.getElementById("name").innerHTML = uesr.name;
    document.getElementById("portrait").src = uesr.portrait;
    document.getElementById("personality").innerHTML = uesr.personality;
  }
}

//文章注入
function data_invittation(data) {
  //  console.log(data);
  document.getElementById("number").innerHTML = `【标题】${data.title}`;
  document.getElementById("time").innerHTML = `发表于 ${data.time}`;
  document.getElementById("text").innerHTML = data.text;
}

function data_good(data, my) {
  document.getElementById("good").innerHTML = `${data.length} 人赞同`;
  data.forEach((element) => {
    if (element.account === my.account) {
      console.log(
        document.getElementById("good_img").setAttribute("fill", "red")
      );
    }
  });
}

function ajax_invitation() {
  var id = window
    .decodeURIComponent(window.location.search)
    .slice(1)
    .split("&")[0]
    .split("=")[1];
  //  console.log(id);
  if (id) {
    $.ajax({
      tyep: "get",
      url: "http://localhost:8080/maven/article/look",
      //    contentType: "application/x-www-form-urlencoded",
      contentType: "application/json;charset=UTF-8",
      data: { id: id },
      dataType: "json", //返回的数据类型格式
      success: function (data) {
        //       console.log(data);
        data_invittation(data.invitation);
        data_uesr(data.user, data.my);
        data_good(data.goods, data.my);
      },
      error: function () {
        //未登录的时候
        alert("未登录，或则登录已过期");
      },
    });
  }
}

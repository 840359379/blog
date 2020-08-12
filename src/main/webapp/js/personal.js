window.onload = function () {
  ajax_invitation();
};

//填充用户数据
function data_uesr(uesr) {
  var changes = document.getElementsByName("changes");
  if (uesr) {
    document.getElementById("state").innerHTML = uesr.name;
    document.getElementById("state_enroll").innerHTML = "退出登录";
    document.getElementsByClassName(
      "name"
    )[0].innerHTML = `${uesr.name}的放松区`;
    changes[0].value = uesr.name;
    document.getElementsByClassName("name")[1].innerHTML = uesr.name;
    document.getElementsByClassName(
      "personality"
    )[0].innerHTML = `个性签名：${uesr.personality}`;
    changes[4].value = uesr.personality;
    document.getElementsByClassName("personality")[1].innerHTML =
      uesr.personality;
    document.getElementById("mailbox").innerHTML = uesr.mailbox;
    changes[1].value = uesr.mailbox;
    document.getElementById("gender").innerHTML = uesr.gender;
    changes[2].value = uesr.gender;
    document.getElementById("birthday").innerHTML = uesr.birthday;
    changes[3].value = uesr.birthday;
    document.getElementsByClassName("portrait")[0].src = uesr.portrait;
    document.getElementsByClassName("portrait")[1].src = uesr.portrait;
  } else {
    document.getElementsByClassName("name")[0].innerHTML = "放松区";
  }
}

//修改资料的按钮事件
function modify() {
  var unconventional = document.getElementsByClassName("unconventional")[0];
  unconventional.className = "important unconventional";
  //此时加载表单的检查事件
  judge();
}
//取消按钮的事件
function invisible() {
  var unconventional = document.getElementsByClassName("unconventional")[0];
  unconventional.className = "important unconventional display_none";
}

//修改资料的ajax
function submission() {
  var changes = document.getElementsByName("changes");
  $.ajax({
    tyep: "get",
    contentType: "application/x-www-form-urlencoded",
    url: "http://localhost:8080/maven/personal/updateuser",
    data: {
      name: changes[0].value,
      personality: changes[4].value,
      mailbox: changes[1].value,
      gender: changes[2].value,
      birthday: changes[3].value,
    },
    dataType: "json", //返回的数据类型格式
    success: function (data) {
      location.reload();
    },
    error: function () {
      //请求出错处理
      alert("未登录，或则登录已过期");
    },
  });
}
//检查
function judge() {
  var inputs = document.getElementsByName("changes");
  for (var x = 0; x < inputs.length; x++) {
    inputs[x].onfocus = onfocus_judge;
    inputs[x].onblur = onblur_judge;
  }
}

//输入框获得焦点的时候触发的事件
function onfocus_judge(){
  // console.log(this.nextElementSibling);
  this.nextElementSibling.className = "change_vice visibility_none";
}

//输入表单失去焦点时的事件
function onblur_judge(){
  var bool = main(this);
  // console.log(bool);
  if(!bool){
    this.nextElementSibling.className = "change_vice";
  }
}

//获取资料的ajax
function ajax_invitation() {
  $.ajax({
    tyep: "get",
    url: "http://localhost:8080/maven/personal/uesr",
    contentType: "application/x-www-form-urlencoded",
    //    contentType: "application/json;charset=UTF-8",
    data: {},
    dataType: "json", //返回的数据类型格式
    success: function (data) {
      // console.log(data);
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

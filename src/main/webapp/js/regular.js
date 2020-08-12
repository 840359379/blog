function main(data) {
  var id = data.id;
  switch (id) {
    case "change_1":
      var bool = name(data);
      // console.log(bool);
      // console.log("name");
      break;
    case "change_2":
      var bool = mailbox(data);
      // console.log("mailbox");
      break;
    case "change_3":
      var bool = gender(data);
      // console.log(bool);
      //  console.log("gender");
      break;
    case "change_4":
      var bool = birthday(data);
      // console.log("birthday");
      break;
  }
  return bool;
}

function name(data) {
  if (data.value.length == 0) return false;
  else return true;
}

function birthday(data) {
  if (data.value.length == 0) return false;
  else if (/^[1-9][0-9]{3}-[01][0-9]-[0-3][0-9]$/.test(data.value) === false)
    return false;
  else return true;
}

function mailbox(data) {
  if (data.value.length == 0) return false;
  else if (
    /^\w+@[a-zA-Z0-9]{2,10}(?:\.[a-z]{2,4}){1,3}$/.test(data.value) === false
  )
    return false;
  else return true;
}

function gender(data) {
  if (data.value.length == 0) return false;
  else if (/^[男女]$/.test(data.value) === false) return false;
  else return true;
}

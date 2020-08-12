function newdiv(fa, divclass) {
  var div = document.createElement("div");
  div.className = divclass;
  fa.appendChild(div);
  return div;
}
function newimg(fa, imgclass, imgsrc) {
  var img = document.createElement("img");
  img.className = imgclass;
  img.src = imgsrc;
  fa.appendChild(img);
  return img;
}
function newp(fa, pclass, ptext) {
  var p = document.createElement("p");
  p.className = pclass;
  p.innerHTML = ptext;
  fa.appendChild(p);
  return p;
}
function newinput(fa, inputclass, inputtype, inputtext) {
  var input = document.createElement("input");
  input.className = inputclass;
  input.value = inputtext;
  input.type = inputtype;
  fa.appendChild(input);
  return input;
}
function newa(fa, aclass, atext, ahref) {
  var a = document.createElement("a");
  a.className = aclass;
  a.innerHTML = atext;
  a.href = ahref;
  fa.appendChild(a);
  return a;
}
function newbutton(fa, buttonclass, buttontext) {
  var button = document.createElement("button");
  button.className = buttonclass;
  button.innerHTML = buttontext;
  fa.appendChild(button);
  return button;
}

function newtable(fa, tableclass) {
  var table = document.createElement("table");
  table.className = tableclass;
  fa.appendChild(table);
  return table;
}
function newtr(fa, trclass) {
  var tr = document.createElement("tr");
  tr.className = trclass;
  fa.appendChild(tr);
  return tr;
}
function newtd(fa, tdclass, tdtext) {
  var td = document.createElement("td");
  td.className = tdclass;
  td.innerHTML = tdtext;
  fa.appendChild(td);
  return td;
}

function newh(fa, hclass, htext, hx) {
	  var h = document.createElement(`h${hx}`);
	  hclassName = hclass;
	  h.innerHTML = htext;
	  fa.appendChild(h);
	  return h;
}

function newli(fa, liclass) {
	  var li = document.createElement("li");
	  li.className = liclass;
	  fa.appendChild(li);
	  return li;
	}

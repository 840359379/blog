<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>主页</title>
    <link
      rel="stylesheet"
      href="../css/bootstrap-4.4.1-dist/css/bootstrap.css"
    />
    <script src="../js/jquery-3.5.0.min.js" defer></script>
    <script src="../css/bootstrap-4.4.1-dist/js/bootstrap.js" defer></script>
    <link rel="stylesheet" href="../css/homepage.css" />
    <script src="../js/newborn.js"></script>
    <script src="../js/homepage.js" defer></script>
  </head>
  <body>
    <nav
      class="navbar navbar-expand-lg navbar-light bg-light navbar-dark bg-dark"
    >
      <a class="navbar-brand" href="#" id="state">;/;</a>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="homepage.jsp"
              >首页<span class="sr-only">(current)</span></a
            >
          </li>

          <li class="nav-item">
            <a class="nav-link" href="personal.html">个人中心</a>
          </li>

          <li class="nav-item">
            <a class="nav-link" href="personal_invitation.html">发帖</a>
          </li>

          <li class="nav-item dropdown">
            <a
              class="nav-link dropdown-toggle"
              href="#"
              id="navbarDropdown"
              role="button"
              data-toggle="dropdown"
              aria-haspopup="true"
              aria-expanded="false"
            >
              其他
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="#">收藏</a>
              <a class="dropdown-item" href="#">留言板</a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" id="state_enroll" href="../state"
                >退出登录</a
              >
            </div>
          </li>
          <!-- <li class="nav-item">
            <a
              class="nav-link disabled"
              href="#"
              tabindex="-1"
              aria-disabled="true"
              >Disabled</a
            >
          </li> -->
        </ul>
        <form class="form-inline my-2 my-lg-0" action="search.html">
          <input
            class="form-control mr-sm-2"
            name="search"
            type="search"
            placeholder="查找帖子"
            aria-label="查找帖子"
          />
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">
            搜索
          </button>
        </form>
      </div>
    </nav>

    <!-- Stack the columns on mobile by making one full-width and the other half-width -->
    <div class="da">
      <div class="row">
        <div class="col-md-7" id="post_area">
          <div class="card">
            <h5 class="card-header">最新热帖</h5>
            <div class="card-body" id="invitation_area"></div>
          </div>
        </div>

        <div class="col-md-4 lift">
          <div class="Userfa">
            <div class="User" id="uesr">
              <div class="img">
                <a><img src="../picture/tou.jpg" class="User_img_1" /></a>
              </div>
              <div class="Username">
                <b id="name"></b>
                <p id="personality"></p>
              </div>
              <div class="Line"></div>
              <div class="basic">
                <div class="basics">
                  <p class="basics_zi">贴数</p>
                  <div class="line_2"></div>
                  <a href="personal_1.html"
                    ><p class="basics_ge" id="invitation">0</p></a
                  >
                </div>
                <div class="basics">
                  <p class="basics_zi">关注</p>
                  <div class="line_2"></div>
                  <a href="personal_follow.html"
                    ><p class="basics_ge" id="follow">0</p></a
                  >
                </div>
                <div class="basics">
                  <p class="basics_zi">粉丝</p>
                  <div class="line_2"></div>
                  <a href="personal_fans.html"
                    ><p class="basics_ge" id="fans">0</p></a
                  >
                </div>
              </div>
            </div>
          </div>

          <div class="card data">
            <img src="../picture/data.jpg" class="card-img-top" alt="日期" />
            <div class="card-body">
              <p class="card-text data_rili">
                2020-4-26 13:00:00
              </p>
            </div>
          </div>

          <div class="card my_0" style="width: 18rem;">
            <div class="card-header">
              近期发帖
            </div>
            <ul class="list-group list-group-flush" id="myinvitations"></ul>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
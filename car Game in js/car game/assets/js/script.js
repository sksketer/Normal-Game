
$(function () {
    var anim_id;
    var container = $('#container'),
    car = $('#car'),
    car_1 = $('#car_1'),
    car_2 = $('#car_2'),
    car_3 = $('#car_3'),
    line_1 = $('.line_1'),
    line_2 = $('.line_2'),
    line_3 = $('.line_3'),
    line_4 = $('.line_4'),
    line_5 = $('.line_5'),
    line_6 = $('.line_6'),
    restart_div = $('#restart_div'),
    restart_btn = $('#restart'),
    score = $('#score');
    //saving some initial setup
    var container_left = parseInt(container.css('left')),
    container_width = parseInt(container.width()),
    container_height = parseInt(container.height()),
    car_width = parseInt(car.width()),
    car_height = parseInt(car.height()),
    line_width_l = parseInt(line_5.width()),
    line_width_r = parseInt(line_6.width());
    //some other declarations
    var game_over = false,
    score_counter = 1,
    speed = 5,
    line_speed = 2,
    move_right = false,
    move_left = false,
    move_up = false,
    move_down = false;



    /* ------------------------------GAME CODE STARTS HERE------------------------------------------- */
    /* Move the cars */
    $(document).on('keydown', function (e) {
    if (game_over === false) {
    var key = e.keyCode;
    if (key === 37 && move_left === false) {
    move_left = requestAnimationFrame(left);
} else if (key === 39 && move_right === false) {
    move_right = requestAnimationFrame(right);
} else if (key === 38 && move_up === false) {
    move_up = requestAnimationFrame(up);
} else if (key === 40 && move_down === false) {
    move_down = requestAnimationFrame(down);
}
}
});
    $(document).on('keyup', function (e) {
    if (game_over === false) {
    var key = e.keyCode;
    if (key === 37) {
    cancelAnimationFrame(move_left);
    move_left = false;
} else if (key === 39) {
    cancelAnimationFrame(move_right);
    move_right = false;
} else if (key === 38) {
    cancelAnimationFrame(move_up);
    move_up = false;
} else if (key === 40) {
    cancelAnimationFrame(move_down);
    move_down = false;
}
}
});
    function left() {
    if (game_over === false && parseInt(car.css('left')) > line_width_l) {
    car.css('left', parseInt(car.css('left')) - 5);
    move_left = requestAnimationFrame(left);
}
}
    function right() {
    if (game_over === false && parseInt(car.css('left')) < container_width - car_width - line_width_r) {
    car.css('left', parseInt(car.css('left')) + 5);
    move_right = requestAnimationFrame(right);
}
}
    function up() {
    if (game_over === false && parseInt(car.css('top')) > 10) {
    car.css('top', parseInt(car.css('top')) - 3);
    move_up = requestAnimationFrame(up);
}
}
    function down() {
    if (game_over === false && parseInt(car.css('top')) < container_height - car_height - 10) {
    car.css('top', parseInt(car.css('top')) + 3);
    move_down = requestAnimationFrame(down);
}
}
    /* Move the cars and lines */
    anim_id = requestAnimationFrame(repeat);
    function repeat() {
    if (game_over === false) {
    if (collision(car, car_1) || collision(car, car_2) || collision(car, car_3)) {
    stop_the_game();
}
    score_counter++;
    if (score_counter % 20 == 0) {
    score.text(parseInt(score.text()) + 1);
}
    if (score_counter % 500 == 0) {
    speed++;
    line_speed++;
}
    car_down(car_1);
    car_down(car_2);
    car_down(car_3);
    line_down(line_1);
    line_down(line_2);
    line_down(line_3);
    line_down(line_4);
    anim_id = requestAnimationFrame(repeat);
}
}
    function car_down(car) {
    var car_current_top = parseInt(car.css('top'));
    if (car_current_top > container_height) {
    car_current_top = -200;
    var car_left = parseInt(Math.random() * (container_width - car_width - line_width_l));
    car.css('left', car_left);
}
    car.css('top', car_current_top + speed);
}
    function line_down(line) {
    var line_current_top = parseInt(line.css('top'));
    if (line_current_top > container_height) {
    line_current_top = -200;
}
    line.css('top', line_current_top + line_speed);
}
    restart_btn.click(function () {
    location.reload();
});
    function stop_the_game() {
    game_over = true;
    cancelAnimationFrame(anim_id);
    cancelAnimationFrame(move_right);
    cancelAnimationFrame(move_left);
    cancelAnimationFrame(move_up);
    cancelAnimationFrame(move_down);
    restart_div.slideDown();
    restart_btn.focus();
}
    /* ------------------------------GAME CODE ENDS HERE------------------------------------------- */
    function collision($div1, $div2) {
    var x1 = $div1.offset().left,
    y1 = $div1.offset().top,
    h1 = $div1.outerHeight(true),
    w1 = $div1.outerWidth(true),
    b1 = y1 + h1,
    r1 = x1 + w1,
    x2 = $div2.offset().left,
    y2 = $div2.offset().top,
    h2 = $div2.outerHeight(true),
    w2 = $div2.outerWidth(true),
    b2 = y2 + h2,
    r2 = x2 + w2;
    if (b1 < y2 || y1 > b2 || r1 < x2 || x1 > r2) return false;
    return true;
}
});
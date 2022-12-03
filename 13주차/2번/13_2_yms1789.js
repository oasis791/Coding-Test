function solution(orders, course) {
  let answer = [];

  const combinations = function (menu, order, cnt, idx, prev) {
    if (prev.length === cnt) {
      let curStr = prev.sort().join("");
      if (menu.has(curStr)) menu.set(curStr, menu.get(curStr) + 1);
      else menu.set(curStr, 1);
    }
    for (let i = idx; i < order.length; i++) {
      combinations(menu, order, cnt, i + 1, [...prev, order[i]]);
    }
  };
  let menu = new Map();
  orders.map((order) => {
    course.map((cnt) => combinations(menu, order, cnt, 0, []));
  });
  menu = [...menu.entries()].filter((elem) => elem[1] >= 2);
  let result = [];
  course.map((cnt) => {
    let max = 0;
    let tmp = menu.filter(([str, num]) => {
      if (max < num && str.length === cnt) max = num;
      return str.length === cnt;
    });
    tmp.filter((x) => x[1] === max).map((x) => result.push(x[0]));
  });
  return result.sort();
}

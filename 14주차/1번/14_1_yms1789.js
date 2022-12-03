function solution(skill, skill_trees) {
  let answer = 0;
  skill_trees.map((tree) => {
    tree = tree.split("");
    let treeList = tree.filter((ele) => skill.includes(ele));
    if (!treeList.length) {
      answer++;
    }
    if (skill.includes(treeList.join("")) && treeList.includes(skill[0])) {
      answer++;
    }
  });
  return answer;
}

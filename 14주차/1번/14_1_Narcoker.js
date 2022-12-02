function solution(skill, skill_trees) {
    function checkSkill(targetSkillTree) {
        let canLearnSkillIndex = 0;
        for (let i = 0; i < targetSkillTree.length; i++) {
            if ((skill.includes(targetSkillTree[i]))) {
                if (skill[canLearnSkillIndex] !== targetSkillTree[i])
                    return false;
                if (skill[canLearnSkillIndex] === targetSkillTree[i])
                    canLearnSkillIndex++;
            }
        }
        return true;
    }
    let answer = 0;
    for (let targetSkillTree of skill_trees) {
        if (checkSkill(targetSkillTree)) answer++;
    }
    return answer;
}
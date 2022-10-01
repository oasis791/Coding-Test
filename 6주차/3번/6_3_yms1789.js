function solution(survey, choices) {
  let answer = "";
  let mbti = {
    R: 0,
    T: 0,
    C: 0,
    F: 0,
    J: 0,
    M: 0,
    A: 0,
    N: 0,
  };
  choices = choices.map((ele) => ele - 4);

  for (let i = 0; i < survey.length; i++) {
    if (choices[i] > 0) {
      mbti[survey[i][1]] = choices[i];
    } else if (choices[i] < 0) {
      mbti[survey[i][0]] = Math.abs(choices[i]);
    }
  }
  console.log(mbti);

  if (mbti["R"] >= mbti["T"]) {
    answer += "R";
  } else {
    answer += "T";
  }
  if (mbti["C"] >= mbti["F"]) {
    answer += "C";
  } else {
    answer += "F";
  }
  if (mbti["J"] >= mbti["M"]) {
    answer += "J";
  } else {
    answer += "M";
  }
  if (mbti["A"] >= mbti["N"]) {
    answer += "A";
  } else {
    answer += "N";
  }

  return answer;
}

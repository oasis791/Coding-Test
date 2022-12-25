import re

def replace_sharp_melody(melody):
    note = {"C#": "c", "D#":"d", "F#":"f", "G#":"g", "A#":"a"}
    
    for _from, _to in note.items():
        melody = melody.replace(_from, _to)
    
    return melody


def to_minute(time):
    hour, minute = time.split(":")
    hour, minute = int(hour), int(minute)
    return hour * 60 + minute


def get_total_melody(play_time, original_melody):
    length = len(original_melody)
    result = []
    i, current_play_time = 0, 0
    
    while current_play_time < play_time:
        result.append(original_melody[i])
        i += 1
        current_play_time += 1
        
        if i >= length:
            i = 0

    return "".join(result)


def solution(m, musicinfos):
    answer = ("(None)", None)
    m = replace_sharp_melody(m)
    
    for info in musicinfos:
        start_time, end_time, title, melody = info.split(",")
        play_time = to_minute(end_time) - to_minute(start_time)
        
        melody = replace_sharp_melody(melody)
        total_melody = get_total_melody(play_time, melody)

        searcher = re.compile(m)
        search_result = searcher.search(total_melody)

        if search_result:
            pattern = search_result.group()
 
            if(answer[1] == None) or (play_time > answer[1]):
                answer = (title, play_time)
    
    return answer[0]


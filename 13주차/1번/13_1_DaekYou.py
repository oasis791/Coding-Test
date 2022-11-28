def solution(citations):
    thesis_num = len(citations)
    citations.sort()
    
    for i in range(thesis_num):
        remained_thesises_with_current_thesis = thesis_num - i

        if citations[i] >= remained_thesises_with_current_thesis:
            return remained_thesises_with_current_thesis
    return 0
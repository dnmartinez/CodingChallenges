import sys

def main():
    lst_size = input()
    str_nums = input().split(" ")  # a list of numbers without spaces

    correct_input = validate_input(lst_size, str_nums)
    result = is_majority(correct_input)
    print(result)

def validate_input(lst_size, str_nums):
    try:
        lst_size = int(lst_size)
        int_nums = [int(num) for num in str_nums]  # list comprehension
    except ValueError:
        sys.exit("Oops!  Input must be a number and not empty.  Try again.")
    else:
        if lst_size == len(int_nums):
            # print("the list size entered is equal to the actual list length")
            pass
        elif lst_size > len(int_nums):
            print("No")
            sys.exit("the list size entered is greater than the actual list length")
        else:
            print("No")
            sys.exit("the list size entered  is less than the actual list length")
    correct_input = (lst_size, int_nums)
    return correct_input

def is_majority(correct_input):
    size, lst = correct_input
    majority = int(size / 2 + 1)
    nums_dict = {number: lst.count(number) for number in lst}
    max_key = max(nums_dict, key=lambda i: nums_dict[i])
    if nums_dict[max_key] >= majority:
        answer = "Yes " + str(max_key)
        return answer
    else:
        return "No"

if __name__ == '__main__':
    main()

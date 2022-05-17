# input() reads a string with a line of input, stripping the ' ' (newline) at the end.
# This is all you need for most Kick Start problems.
t = int(input()) # read a line with a single integer
for i in range(1, t + 1):
    n, b = [int(s) for s in input().split(" ")] # read a list of integers, 2 in this case
    a = [int(s) for s in input().split(" ")]

    a.sort()
    ans = 0
    for pos in range(0, n):
        if b >= a[pos]:
            b-= a[pos]
            ans = ans+1

    print("Case #{}: {}".format(i, ans))
    # check out .format's specification for more formatting options


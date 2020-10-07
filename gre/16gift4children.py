def factorial(n):
    fac = 1
    for nb in range(1,int(n+1)):
        fac *=nb
    return fac


gifts = 16
children = 4
print(factorial(gifts))
print(factorial(children))

res = factorial(gifts)/(factorial(children)**children)

print(res)

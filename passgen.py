from itertools import permutations, combinations

INPUT_LIST = 'sample.list'
OUTPUT_LIST = 'output.list'
COMBO_MAX = 5

if __name__ == '__main__':
  with open(INPUT_LIST, 'r') as wordlist:
    with open(OUTPUT_LIST, 'a') as output:
      words = [word.strip() for word in wordlist.readlines()]
      for size in range(1, COMBO_MAX+1):
        combos = combinations(words, size)
        for combo in combos:
          password = ''.join([word.strip() for word in list(combo)])
          output.write('{}\n'.format(password.strip()))

  # Add permutations to the generated list
  
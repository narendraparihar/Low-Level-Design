Bloom Filter is probablistic datastructure.
which can give false positive as response for asking whether any record is present in set.
but it never gives false negative as response.

Working of Bloom Filter:

1. Bloom filter has bucket and list of hashFunctions.
2. bucket is used to store the records parsed from hashFunctions;

sequence of action in Bloom filter :

1. User add any record in bloom filter with add() method.
2. filter will run "k" hashFunctions on that record and will generate "k" different outputs.
3. then it will set all k bits to mark it as stored.
4. User will call mightContain() method
5. again all the "k" hash functions will be ran and it'll check all "k" bits in bucket.
6. If any of the bit is not set then it will return false otherwise it will return true;

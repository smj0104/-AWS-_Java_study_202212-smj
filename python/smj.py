url = 'https://archive.ics.uci.edu/ml/machine-learning-databases/abalone/abalone.data'
import numpy as np
import requests

url = 'https://archive.ics.uci.edu/ml/machine-learning-databases/abalone/abalone.data'
def fetch_uci_data(url):
    d = requests.get(url)
    t = []
    for line in d.text.split('\n'):
        if len(line)!=0:
            t.append(line.split(','))
    return np.array(t)

    #len_check = set()
    #for e in t:
    #    in(len(e)==1):
    #        print(e)
    #    len_check.add(len(e))
    #print(len_check)
    
    return np.array(t)

def get_corr(d):
    male_filter = d[:,0]=='M'
    male_samples = d[male_filter]
    male_length = male_samples[:,1].astype(np.float64)
    male_diamter = male_samples[:,2].astype(np.float64)
    return np.corrcoef(male_length, male_diamter)


if __name__ == '__main__':
    np_data = fetch_uci_data(url)
    corr_value = get_corr(np_data)
    print(corr_value)
    print(corr_value[0,1])
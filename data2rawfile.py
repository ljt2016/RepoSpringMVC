import pymongo
import time
import os


class DataTrans:
    def __init__(self):
        client = pymongo.MongoClient('101.132.148.190', 27017)
        client.label_work.authenticate('l_worker', 'l_worker@lwork')
        self.__db = client['label_work']

    def __data2str(self, doc, heads):
        doc['comment'] = doc['comment'].replace('\n', '去')
        doc['check_labels'] = doc.get('check_labels', 'ReplierWithoutLabeled')
        if doc['role'] == 'reviewer':
            doc['check_labels'] = ','.join(doc['check_labels'])
        t_cnt = [doc[h] for h in heads]
        cnt = '邹'.join(t_cnt)
        return cnt

    def trans_one(self, coll):
        '''
        This function transfer data that has been labeled in collection coll to raw data type.
        :param coll: Certain collection name.
        :return: Output "[coll].res" that is raw data type.
        '''
        t = int(time.time())
        docs = self.__db[coll].find({'check_labels':{'$elemMatch':{'$ne':'null'}}})
        num = 0
        heads = []
        with open('dwld_data/' + coll + '%d.res'%t, 'a+', encoding='utf-8') as f:
            for doc in docs:
                if not num:
                    heads = [h for h in doc if h not in ['_id', 'reply', 'rqst_grp_id']]
                    head = '邹'.join(heads)
                    f.write(head+'\n')
                rev_data = dict()
                rev_data.update(doc)
                reps = rev_data.pop('reply')
                cnt = self.__data2str(rev_data, heads)
                f.write(cnt+'\n')
                for rep in reps:
                    rp_cnt = self.__data2str(rep, heads)
                    f.write(rp_cnt+'\n')
                num += 1
        if not num:
            os.remove('dwld_data/' + coll + '%d.res'%t)
            print("%s project has not been labeled."%coll)
        else:
            print("%s project has been transferred with %d lines."%(coll, num))

    def trans_many(self, colls):
        '''
        This function trans more than one projects data to raw file.
        :param colls: Projects set.
        :return:"[coll].res" that is raw data type.
        '''
        for coll in colls:
            self.trans_one(coll)

    def __get_all_colls(self):
        return self.__db.collection_names(include_system_collections=False)

    def trans_all(self):
        all_colls = self.__get_all_colls()
        self.trans_many(all_colls)

def main():
    dt = DataTrans()
    # dt.trans_one('new_test')
    dt.trans_all()

if __name__ == '__main__':
    main()
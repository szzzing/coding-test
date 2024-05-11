SELECT A.WRITER_ID AS USER_ID
     , UGU.NICKNAME
     , A.TOTAL_SALES
  FROM (
        SELECT SUM(PRICE) TOTAL_SALES
             , WRITER_ID
             , STATUS
          FROM USED_GOODS_BOARD UGB
         WHERE UGB.STATUS = 'DONE'
         GROUP BY WRITER_ID
        HAVING TOTAL_SALES >= 700000
        ) A
  JOIN USED_GOODS_USER UGU
    ON UGU.USER_ID = A.WRITER_ID
 ORDER BY A.TOTAL_SALES 
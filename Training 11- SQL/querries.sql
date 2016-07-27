USE homework_schema;

SELECT f.* 
FROM factura f
WHERE f.id = (SELECT aux.id 
			  FROM (SELECT df.factura_id AS id, sum(df.pret * df.cantitate) AS total 
					FROM detaliu_factura df 
					GROUP BY df.factura_id) aux HAVING aux.total = max(aux.total));
		

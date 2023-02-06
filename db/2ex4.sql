CREATE DEFINER=`root`@`localhost` TRIGGER `user_mst_AFTER_DELETE` AFTER DELETE ON `user_mst` FOR EACH ROW BEGIN
	delete
	from
		user_dtl
	where 
		user_id = old.user_id;
END
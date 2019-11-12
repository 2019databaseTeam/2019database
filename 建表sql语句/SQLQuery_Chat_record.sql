USE [database_project]
GO

/****** Object:  Table [dbo].[ChatRecord]    Script Date: 2019/11/11 20:23:46 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[ChatRecord](
	[mes_id] [int] NOT NULL,
	[u_id_send] [int] NOT NULL CONSTRAINT S_Fore FOREIGN KEY REFERENCES S(u_id_send),
	[u_id_receive] [int] NOT NULL CONSTRAINT S_Tore FOREIGN KEY REFERENCES SC(u_id_receive),
	[time] [datetime] NOT NULL,
	[content] [text] NOT NULL
	
) ON [PRIMARY]

GO



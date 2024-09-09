import React from 'react';

import bgImg from '../../assets/tree.png';

const BackLayout: React.FC = ({ children }) => {
  return <div className="w-[1034px] h-[1034px]">{children}</div>;
};

export default BackLayout;
